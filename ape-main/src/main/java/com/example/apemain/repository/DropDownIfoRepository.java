package com.example.apemain.repository;

import com.example.apemain.domains.returns.IdToNameInfomation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

@Repository
@AllArgsConstructor
public class DropDownIfoRepository {
    private final DataSource dataSource;
    public List<IdToNameInfomation> getAllIstrumentTypes(Connection connection) throws Exception {
        String sql= "SELECT instrument_type_name,id from instrument_type;";
        //Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            List<IdToNameInfomation> instrumentList=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("instrument_type_name");
                Integer id=resultSet.getInt("id");
                instrumentList.add(new IdToNameInfomation(id,name));
            }
            return List.copyOf(instrumentList);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public List<IdToNameInfomation> getRecordGenres(Connection connection) throws Exception {
        String sql= "SELECT name,id from genre;";
        //Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            List<IdToNameInfomation> instrumentList=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Integer id=resultSet.getInt("id");

                instrumentList.add(new IdToNameInfomation(id,name));
            }
            return List.copyOf(instrumentList);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public List<IdToNameInfomation> getCompanyNames(Connection connection) throws Exception {
        String sql= "select company.name, company.id from company;";
        //Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            List<IdToNameInfomation> companies=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Integer id=resultSet.getInt("id");

                companies.add(new IdToNameInfomation(id,name));
            }
            return List.copyOf(companies);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public List<IdToNameInfomation> getArtistNames(Connection connection) throws Exception {
        String sql= "select artist.name,artist.id from artist;";
        //Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            List<IdToNameInfomation> artists=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Integer id=resultSet.getInt("id");

                artists.add(new IdToNameInfomation(id,name));
            }
            return List.copyOf(artists);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public List<IdToNameInfomation> getRecordLabelNames(Connection connection) throws Exception {
        String sql= "select record_label.name, record_label.id  from record_label;";
        //Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            List<IdToNameInfomation> artists=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Integer id=resultSet.getInt("id");

                artists.add(new IdToNameInfomation(id,name));
            }
            return List.copyOf(artists);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public List<IdToNameInfomation> getInstrumentNames(Connection connection) throws Exception {
        String sql= "select i.name, i.item_id  from instrument i2 " +
                    "join public.item i on i.item_id = i2.item_id ;";
        //Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            List<IdToNameInfomation> records=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Integer id= resultSet.getInt("item_id");

                records.add(new IdToNameInfomation(id, name));
            }
            return List.copyOf(records);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public List<IdToNameInfomation> getRecordNames(Connection connection) throws Exception {
        String sql= "select i.name, i.item_id  from record r " +
                    "join public.item i on i.item_id = r.item_id ;";
        //Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            List<IdToNameInfomation> records=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Integer id= resultSet.getInt("item_id");

                records.add(new IdToNameInfomation(id, name));
            }
            return List.copyOf(records);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }
}

