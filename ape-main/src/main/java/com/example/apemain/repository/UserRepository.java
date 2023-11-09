package com.example.apemain.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final DataSource dataSource;

    public int logIn(final String email,final String password) throws Exception {

        String sql= "SELECT id  from ape_user " +
                    "where ape_user.password =? AND ape_user.email=?";

        Connection connection = DataSourceUtils.getConnection(dataSource);
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, password);
            statement.setString(2, email);


            ResultSet resultSet= statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
