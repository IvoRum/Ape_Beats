package com.example.apemain.repository;

import com.example.apemain.domains.UserProfileDate;
import com.example.apemain.domains.returns.UserSaleData;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public List<UserSaleData> getUserSales(int userId) throws Exception {

        String sql= "SELECT sale.number , sale.amount, sale.time_stamp, sale.fulfill from sale " +
                "join public.ape_user au on au.id = sale.ape_user " +
                "where au.id=? " +
                "group by au.email, sale.number;";

        Connection connection = DataSourceUtils.getConnection(dataSource);
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            List<UserSaleData> result= new ArrayList<>();

            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()) {
                int number=resultSet.getInt("number");
                int amount=resultSet.getInt("amount");
                Date phone=resultSet.getDate("time_stamp");
                boolean firstName=resultSet.getBoolean("fulfill");

                result.add(new UserSaleData(number,amount,phone,firstName));
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
