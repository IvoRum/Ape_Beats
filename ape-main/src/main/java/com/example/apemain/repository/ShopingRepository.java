package com.example.apemain.repository;

import com.example.apemain.domains.returns.ShopinCartItem;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class ShopingRepository {

    private DataSource dataSource;

    public int createShopingCart(int userId) throws Exception {

        String sql= "insert into sale(number, ape_user, amount, fulfill, time_stamp) " +
                    "values (?,?,0,false, CURRENT_DATE);";

        int newSaleNumberget=lastSaleNumber()+1;
        Connection connection = DataSourceUtils.getConnection(dataSource);
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, newSaleNumberget);
            statement.setInt(2, userId);

            statement.execute();
        }
        return newSaleNumberget;
    }

    public int cheIfShopingCartExistsForUser(int userId) throws Exception {

        String sql= "SELECT s.number from ape_user " +
                "join public.sale s on ape_user.id = s.ape_user " +
                "where s.fulfill=false and s.ape_user=?;";

        Connection connection = DataSourceUtils.getConnection(dataSource);
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet resultSet =statement.executeQuery();
            if(!resultSet.next()){
                return 0;
            }
            int existingCartNumber=resultSet.getInt("number");
            return existingCartNumber;
        }catch (Exception e){
            throw new Exception();
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
            throw new Exception();
        }
    }

    private int lastSaleNumber() {

        String sql = "SELECT sale.number from sale " +
                     "order by sale.number desc LIMIT 1;";
        Connection connection = DataSourceUtils.getConnection(dataSource);
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("number");
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ShopinCartItem> getUsersShopingCartItems(int userId) throws Exception {

        String sql= "select i.name,i.price,i.discrimination  from sale " +
                "join public.sale_item si on sale.number = si.sale " +
                "join public.ape_user au on sale.ape_user = au.id " +
                "               join public.item i on i.item_id = si.item " +
                "where au.id=? and sale.fulfill=false";

        Connection connection = DataSourceUtils.getConnection(dataSource);
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet resultSet =statement.executeQuery();
            List<ShopinCartItem> cartItems=new ArrayList<>();
            while(resultSet.next()){
                cartItems.add(
                        new ShopinCartItem(
                                resultSet.getString("name"),
                                resultSet.getInt("price"),
                                resultSet.getString("discrimination")
                        )
                );
            }
            return cartItems;
        }catch (Exception e){
            throw new Exception();
        }
    }
}
