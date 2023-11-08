package com.example.apemain.repository;

import com.example.apemain.domains.Instrument;
import com.example.apemain.domains.ItemIformation;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class DropDownIfoRepository {
    private final DataSource dataSource;
    public List<String> getAllIstrumentTypes(Connection connection) throws Exception {
        String sql= "SELECT instrument_type_name from instrument_type;";
        //Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            List<String> instrumentList=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("instrument_type_name");
                instrumentList.add(name);
            }
            return List.copyOf(instrumentList);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public List<String> getRecordGenres(Connection connection) throws Exception {
        String sql= "SELECT name from genre;";
        //Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            List<String> instrumentList=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                instrumentList.add(name);
            }
            return List.copyOf(instrumentList);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public List<String> getCompanyNames(Connection connection) throws Exception {
        String sql= "select company.name from company;";
        //Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            List<String> companies=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                companies.add(name);
            }
            return List.copyOf(companies);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public List<String> getArtistNames(Connection connection) throws Exception {
        String sql= "select artist.name from artist;";
        //Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            List<String> artists=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                artists.add(name);
            }
            return List.copyOf(artists);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public List<String> getRecordLabelNames(Connection connection) throws Exception {
        String sql= "select record_label.name  from record_label;";
        //Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            List<String> artists=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                artists.add(name);
            }
            return List.copyOf(artists);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public List<ItemIformation> getInstrumentNames(Connection connection) throws Exception {
        String sql= "select i.name, i.item_id  from instrument i2 " +
                    "join public.item i on i.item_id = i2.item_id ;";
        //Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            List<ItemIformation> records=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Integer id= resultSet.getInt("item_id");

                records.add(new ItemIformation(id,name));
            }
            return List.copyOf(records);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public List<ItemIformation> getRecordNames(Connection connection) throws Exception {
        String sql= "select i.name, i.item_id  from record r " +
                    "join public.item i on i.item_id = r.item_id ;";
        //Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            List<ItemIformation> records=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Integer id= resultSet.getInt("item_id");

                records.add(new ItemIformation(id,name));
            }
            return List.copyOf(records);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }
}

