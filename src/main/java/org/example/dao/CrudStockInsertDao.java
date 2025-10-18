package org.example.dao;

import org.example.model.StockPriceHistory;

import java.sql.*;
import java.util.List;

public class CrudStockInsertDao {
    static final String DB_URL = "jdbc:postgresql://endeavourtech.ddns.net:50271/CrudDB";
    static final String USER = "endeavour_test_area";
    static final String PASS = "Endeavour01";

    public void insertStocks(List<StockPriceHistory> stocks) {
        String insertQuery = "INSERT INTO endeavour_test_area.stock_price_yash " +
                "(ticker_symbol, close_price, volume, trading_date) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(insertQuery)) {

            int batchSize = 0;

            for (StockPriceHistory stock : stocks) {
                ps.setString(1, stock.getTickerSymbol());
                ps.setDouble(2, stock.getClosePrice());
                ps.setLong(3, stock.getVolume());
                ps.setDate(4, Date.valueOf(stock.getDate()));
                ps.addBatch();

                if (++batchSize % 500 == 0) ps.executeBatch(); // flush every 500 records
            }

            ps.executeBatch();
            System.out.println(" Data inserted successfully into CrudDB.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
