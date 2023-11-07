package com.example.apemain.repository;

import com.example.apemain.domains.Instrument;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class DropDownIfoRepository {
    private final DataSource dataSource;
    public List<String> getAllIstrumentTypes() throws Exception {
        String sql= "SELECT instrument_type_name from instrument_type;";
        Connection connection = DataSourceUtils.getConnection(dataSource);

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

    public List<String> getRecordGenres() throws Exception {
        String sql= "SELECT name from genre;";
        Connection connection = DataSourceUtils.getConnection(dataSource);

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
}

