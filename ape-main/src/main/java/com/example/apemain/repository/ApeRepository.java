package com.example.apemain.repository;

import com.example.apemain.domains.Artist;
import com.example.apemain.domains.Instrument;
import com.example.apemain.domains.returns.MostSoldItem;
import com.example.apemain.domains.Record;

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
        String sql= "SELECT i3.item_id, " +
                "it.instrument_type_name, " +
                "i3.name as item_name,c.name as company_name,i3.stock,i3.price,i3.manufacturing_date, " +
                "i3.discrimination ,"+
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
                    int id=resultSet.getInt("item_id");
                    String name = resultSet.getString("item_name");
                    String company = resultSet.getString("company_name");
                    boolean stock = resultSet.getBoolean("stock");
                    Date date = resultSet.getDate("manufacturing_date");
                    String genre = resultSet.getString("genre_name");
                    int price = resultSet.getInt("price");
                    String type = resultSet.getString("instrument_type_name");
                    String des = resultSet.getString("discrimination");

                    instrumentList.add(new Instrument(id,type, name, company, stock, price, date, genre, des));
            }
            connection.close();
            return List.copyOf(instrumentList);
        } catch (SQLException e) {
            e.printStackTrace();
            connection.close();
            throw new Exception();
        }
    }

    public List<Record> getAllRecordData() throws Exception {
        String sql= "SELECT i.item_id, i.name as item_name ,i.price,i.stock,a.name as artist_name,rl.name as record_label_name, " +
                "i.discrimination from record "+
                "join public.artist a on a.id = record.artist " +
                "join public.record_label rl on rl.id = record.record_label " +
                "join public.item i on i.item_id = record.item_id;";
        Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            List<Record> recordList=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("item_id");
                String name = resultSet.getString("item_name");
                int price = resultSet.getInt("price");
                boolean stock = resultSet.getBoolean("stock");
                String artisnName = resultSet.getString("artist_name");
                String recordLabel = resultSet.getString("record_label_name");
                String des = resultSet.getString("discrimination");

                recordList.add(new Record(id,name,price,stock,artisnName,recordLabel,des));
            }
            return List.copyOf(recordList);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public List<Artist> getAllArtistData() throws Exception {
        String sql= "SELECT artist.name as artist_name, rl.name as record_label_name from artist " +
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
        String sql= "SELECT count(sale_item.item) as count_,i.name, i.discrimination as img_url from sale_item " +
                "    join public.item i on sale_item.item=i.item_id " +
                "group by i.name, i.discrimination " +
                "order by count_ desc " +
                "LIMIT 1;";
        Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int count = resultSet.getInt("count_");
                String des = resultSet.getString("img_url");

                return new MostSoldItem(count,name,des);
            }else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public Artist getArtistByName(String artistName) throws Exception {

        String sql= "SELECT artist.name as artist_name, rl.name as record_label_name from artist " +
                "join public.record r on artist.id = r.artist " +
                "join public.record_label rl on artist.record_label = rl.id " +
                "where artist.name = ? " +
                "Limit 1;";
        Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,artistName);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("artist_name");
                String recordLabel = resultSet.getString("record_label_name");

                return new Artist(name,recordLabel);
            }else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public void insertArtist(String artistName,int recordLabelID,Date date) throws Exception {

        String sql= "INSERT INTO Artist(id,Name,record_label,time_stamp) " +
                "VALUES (?,?,?,?);";

        Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, RepositoryIdGetter.getLastIdArtist(connection)+1);
            statement.setString(2, artistName);
            statement.setInt(3, recordLabelID);
            statement.setDate(4, date);

            statement.executeQuery();
        }
    }

    public void insertInstrument(int price,String description,Date manufacturingDate,String name,int genreId,int companyId,int type,Date date) throws Exception {

        String sql= "INSERT INTO Instrument(Instrument_id,item_id,type,time_stamp) " +
                "VALUES (?,?,?,?); " +
                "insert into instrument_istrument_type(instrument_id, instrument_type_id) " +
                "VALUES(?,?);";
        //"VALUES (4,7,1,'2023-10-28')";
        Connection connection = DataSourceUtils.getConnection(dataSource);
        insertItem(price, description, manufacturingDate, name, genreId, companyId, date,connection);
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            int instrumentID=RepositoryIdGetter.getLastIdInstrument(connection)+1;
            statement.setInt(1,instrumentID );
            statement.setInt(2, RepositoryIdGetter.getLastIdItem(connection));
            statement.setInt(3, type);
            statement.setDate(4, date);
            statement.setInt(5, instrumentID);
            statement.setInt(6, type);

            ResultSet resultSet = statement.executeQuery();
        }
    }

    public void insertRecord(int price,String description,Date manufacturingDate,String name,int genreId,int companyId,Date date,
                             int artistId,int recordLabelId) throws Exception {

        String sql= "INSERT INTO Record(Record_id,item_id,artist,record_label,time_stamp) " +
                "VALUES (?,?,?,?,?);";
                //"VALUES (1,4,1,1,'2023-10-28');";
        Connection connection = DataSourceUtils.getConnection(dataSource);
        insertItem(price, description, manufacturingDate, name, genreId, companyId, date,connection);
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, RepositoryIdGetter.getLastIdRecord(connection)+1);
            statement.setInt(2, RepositoryIdGetter.getLastIdItem(connection));
            statement.setInt(3, artistId);
            statement.setInt(4, recordLabelId);
            statement.setDate(5, date);

            ResultSet resultSet = statement.executeQuery();
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public void insertItem(int price,String description,Date manufacturingDate,String name,int genreId,int companyId,Date date,Connection connection) throws Exception {

        String sql= "INSERT INTO Item(item_id,stock,price,discrimination,manufacturing_date,name,description,genre,company,time_stamp) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?)";
//                "values (1,TRUE,32,'Some diescriopton','2013-10-28','Fender_Squier_Classic','Some diescriopton',1,1,'2023-10-28');\n";
        // = DataSourceUtils.getConnection(dataSource);

        try {PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, RepositoryIdGetter.getLastIdItem(connection)+1);
            statement.setBoolean(2, true);
            statement.setInt(3, price);
            statement.setString(4, description);
            statement.setDate(5, manufacturingDate);
            statement.setString(6, name);
            statement.setString(7, description);
            statement.setInt(8, genreId);
            statement.setInt(9, companyId);
            statement.setDate(10, date);

            statement.executeQuery();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public void updateItemName(int itemId,String name) throws Exception {

        String sql= "UPDATE Item set name = ? where item_id = ? ;";
        Connection connection = DataSourceUtils.getConnection(dataSource);
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, itemId);

            statement.executeQuery();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();

        }
    }


    public List<Instrument> getAllBrassInstrument() throws Exception {
        String sql= "SELECT " +
                    "    it.instrument_type_name, " +
                    "   i3.item_id, i3.name as item_name,c.name as company_name, i3.stock, i3.price, i3.manufacturing_date, i3.discrimination " +
                    "        ,g.name as genre_name " +
                    "FROM instrument " +
                    "         join public.item i3 on i3.item_id = instrument.item_id " +
                    "         join public.genre g on g.id = i3.genre " +
                    "         join public.instrument_istrument_type iit on instrument.instrument_id = iit.instrument_id " +
                    "         join public.instrument_type it on it.id = iit.instrument_type_id " +
                    "         join public.company c on c.id = i3.company " +
                    "WHERE it.id=3;";
        Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            List<Instrument> instrumentList=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("item_id");
                String name = resultSet.getString("item_name");
                String company = resultSet.getString("company_name");
                boolean stock = resultSet.getBoolean("stock");
                Date date = resultSet.getDate("manufacturing_date");
                String genre = resultSet.getString("genre_name");
                int price = resultSet.getInt("price");
                String type = resultSet.getString("instrument_type_name");
                String des = resultSet.getString("discrimination");

                instrumentList.add(new Instrument(id,type, name, company, stock, price, date, genre, des));
            }
            connection.close();
            return List.copyOf(instrumentList);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public List<Instrument> getAllGitarInstrument() throws Exception {
        String sql= "SELECT " +
                    "    it.instrument_type_name, " +
                    "    i3.item_id,i3.name as item_name,c.name as company_name,i3.stock,i3.price,i3.manufacturing_date, i3.discrimination " +
                    "        ,g.name as genre_name " +
                    "FROM instrument " +
                    "         join public.item i3 on i3.item_id = instrument.item_id " +
                    "         join public.genre g on g.id = i3.genre " +
                    "         join public.instrument_istrument_type iit on instrument.instrument_id = iit.instrument_id " +
                    "         join public.instrument_type it on it.id = iit.instrument_type_id " +
                    "         join public.company c on c.id = i3.company " +
                    "WHERE it.id=1;";
        Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            List<Instrument> instrumentList=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("item_id");
                String name = resultSet.getString("item_name");
                String company = resultSet.getString("company_name");
                boolean stock = resultSet.getBoolean("stock");
                Date date = resultSet.getDate("manufacturing_date");
                String genre = resultSet.getString("genre_name");
                int price = resultSet.getInt("price");
                String type = resultSet.getString("instrument_type_name");
                String des = resultSet.getString("discrimination");

                instrumentList.add(new Instrument(id,type, name, company, stock, price, date, genre, des));
            }
            connection.close();
            return List.copyOf(instrumentList);
        } catch (SQLException e) {
            e.printStackTrace();
            connection.close();
            throw new Exception();
        }
    }


}
