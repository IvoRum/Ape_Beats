package com.example.apemain.repository;

import com.example.apemain.domains.Artist;
import com.example.apemain.domains.Instrument;
import com.example.apemain.domains.MostSoldItem;
import com.example.apemain.domains.Record;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ApeRepository {
    private final DataSource dataSource;

    public List<Integer> getallTest(){
        String sql="SELECT * ";
        return null;
    }

    public List<Instrument> getAllInstrumentData() throws Exception {
        String sql= "SELECT " +
                "it.instrument_type_name, " +
                "i3.name as item_name,c.name as company_name,i3.stock,i3.price,i3.manufacturing_date, " +
                "g.name as genre_name " +
                "FROM instrument " +
                "join public.item i3 on i3.item_id = instrument.item_id " +
                "join public.genre g on g.id = i3.genre " +
                "join public.instrument_istrument_type iit on instrument.instrument_id = iit.instrument_id " +
                "join public.instrument_type it on it.id = iit.instrument_type_id " +
                "join public.company c on c.id = i3.company";
        Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            List<Instrument> instrumentList=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                    String name = resultSet.getString("item_name");
                    String company = resultSet.getString("company_name");
                    boolean stock = resultSet.getBoolean("stock");
                    Date date = resultSet.getDate("manufacturing_date");
                    String genre = resultSet.getString("genre_name");
                    int price = resultSet.getInt("price");
                    String type = resultSet.getString("instrument_type_name");

                    instrumentList.add(new Instrument(type, name, company, stock, price, date, genre));
            }
            return List.copyOf(instrumentList);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public List<Record> getAllRecordData() throws Exception {
        String sql= "SELECT i.name as item_name ,i.price,i.stock,a.name as artist_name,rl.name as record_label_name from record " +
                "join public.artist a on a.id = record.artist " +
                "join public.record_label rl on rl.id = record.record_label " +
                "join public.item i on i.item_id = record.item_id;";
        Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            List<Record> recordList=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("item_name");
                int price = resultSet.getInt("price");
                boolean stock = resultSet.getBoolean("stock");
                String artisnName = resultSet.getString("artist_name");
                String recordLabel = resultSet.getString("record_label_name");

                recordList.add(new Record(name,price,stock,artisnName,recordLabel));
            }
            return List.copyOf(recordList);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public List<Artist> getAllArtistData() throws Exception {
        String sql= "SELECT artist.name as artist_name, rl.name as record_label_name from artist " +
                "join public.record r on artist.id = r.artist " +
                "join public.record_label rl on artist.record_label = rl.id;";
        Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            List<Artist> recordList=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("artist_name");
                String recordLabel = resultSet.getString("record_label_name");

                recordList.add(new Artist(name,recordLabel));
            }
            return List.copyOf(recordList);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }


    public List<Artist> getAllArtistDataByName(String artistName) throws Exception {
        String sql= "SELECT artist.name as artist_name, rl.name as record_label_name from artist " +
                "join public.record r on artist.id = r.artist " +
                "join public.record_label rl on artist.record_label = rl.id "+
                "where name='"+artistName+"';";
        Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            List<Artist> recordList=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("artist_name");
                String recordLabel = resultSet.getString("record_label_name");

                recordList.add(new Artist(name,recordLabel));
            }
            return List.copyOf(recordList);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public MostSoldItem getMostSoldItem() throws Exception {
        String sql= "SELECT count(sale_item.item) as count_,i.name from sale_item " +
                "join public.item i on sale_item.item=i.item_id " +
                "group by i.name " +
                "order by count_ desc " +
                "LIMIT 1;";
        Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int count = resultSet.getInt("count_");

                return new MostSoldItem(count,name);
            }else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }
}
