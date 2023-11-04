package com.example.apemain.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositoryIdGetter {

    protected static int getLastIdArtist(Connection connection) throws Exception {

        String sql = "select id from artist " +
                "order by id desc " +
                "LIMIT 1";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                return resultSet.getInt("id");
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    protected static int getLastIdInstrument(Connection connection) throws Exception {

        String sql = "select Instrument_id from instrument " +
                "order by Instrument_id desc " +
                "LIMIT 1;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                return resultSet.getInt("Instrument_id");
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    protected static int getLastIdItem(Connection connection) throws Exception {

        String sql = "select item_id from Item " +
                "order by item_id desc " +
                "LIMIT 1;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                return resultSet.getInt("item_id");
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    protected static int getLastIdRecord(Connection connection) throws Exception {

        String sql = "select Record_id from Record " +
                "order by Record_id desc " +
                "LIMIT 1;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                return resultSet.getInt("Record_id");
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    protected static int getLastIdSale(Connection connection) throws Exception {

        String sql = "select id from Sale " +
                "order by id desc " +
                "LIMIT 1;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                return resultSet.getInt("id");
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }
}
