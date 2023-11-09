package com.example.apemain.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@AllArgsConstructor
public class ShopingRepository {

    private DataSource dataSource;

    public void createShopingCart(int userId) throws Exception {

        String sql= "insert into sale(number, ape_user, amount, fulfill, time_stamp) " +
                    "values (?,?,0,false, CURRENT_DATE);";

        Connection connection = DataSourceUtils.getConnection(dataSource);
        int newSaleNumberget=lastSaleNumber(connection)+1;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, newSaleNumberget);
            statement.setInt(2, userId);

            statement.executeQuery();
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public void addToShopingCart(int saleId,int intemId) throws Exception {

        String sql= "insert into sale_item(sale, item) " +
                    "values (?,?);";

        Connection connection = DataSourceUtils.getConnection(dataSource);

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, saleId);
            statement.setInt(2, intemId);

            statement.executeQuery();
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    private int lastSaleNumber(Connection connection) throws Exception {

        String sql = "SELECT sale.number from sale " +
                     "order by sale.number desc LIMIT 1;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                return resultSet.getInt("number");
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }
}
