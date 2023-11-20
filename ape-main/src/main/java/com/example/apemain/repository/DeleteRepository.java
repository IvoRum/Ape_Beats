package com.example.apemain.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
@Repository
@RequiredArgsConstructor
public class DeleteRepository {
    private final DataSource dataSource;

    public void deleteRecord(int itemId) throws Exception {

        String sql= "delete from record where record.Record_id=?;" +
                "delete from item where item_id=?;";

        Connection connection = DataSourceUtils.getConnection(dataSource);
        int recordId=getRecordId(connection,itemId);
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, recordId);
            statement.setInt(2, itemId);

            statement.execute();
        }
    }

    public void deleteInstrument(int itemId) throws Exception {

        String sql= "delete from instrument_istrument_type where instrument_id=1;" +
                "delete from instrument where instrument_id=1;" +
                "delete from sale_item where item=1;" +
                "delete from item where item_id=1;";

        Connection connection = DataSourceUtils.getConnection(dataSource);
        int instrumentId=getInstrumentId(connection,itemId);
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, instrumentId);
            statement.setInt(2, itemId);

            statement.execute();
        }
    }

    protected static int getRecordId(Connection connection, int itemId) throws Exception {

        String sql = "select record_id from record " +
                "join public.item i on i.item_id = record.item_id " +
                "where i.item_id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, itemId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                return resultSet.getInt("record_id");
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    protected static int getInstrumentId(Connection connection, int itemId) throws Exception {

        String sql = "select instrument_id from instrument " +
                "join public.item i on i.item_id = instrument.item_id " +
                "where i.item_id=?;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, itemId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                return resultSet.getInt("instrument_id");
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }
}
