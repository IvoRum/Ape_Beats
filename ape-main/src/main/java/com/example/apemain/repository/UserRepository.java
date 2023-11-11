package com.example.apemain.repository;

import com.example.apemain.domains.UserProfileDate;
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

    public UserProfileDate getUser(int userId) throws Exception {

        String sql= "SELECT * from ape_user " +
                    "join public.client cl on cl.ape_user=ape_user.id " +
                    "where ape_user.id=?;";

        Connection connection = DataSourceUtils.getConnection(dataSource);
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);

            ResultSet resultSet= statement.executeQuery();
            if (resultSet.next()) {
                int id=resultSet.getInt("id");
                String email=resultSet.getString("email");
                String phone=resultSet.getString("phone");
                String firstName=resultSet.getString("first_name");
                String familyName=resultSet.getString("family_name");
                int status=resultSet.getInt("status");

                return new UserProfileDate(id,email,phone,firstName,familyName,status);
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
