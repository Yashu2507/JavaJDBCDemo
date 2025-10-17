package org.example.dao;

import org.example.model.StockPriceHistory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StocksPriceHistoryDao {
    static final String DB_URL = "jdbc:postgresql://endeavourtech.ddns.net:50271/StocksDB";
    static final String USER = "evr_sql_app";
    static final String PASS = "5LViU5pLkSjRHECec9NF4wRxxV";
    static final String QUERY = "select sph.ticker_symbol , sph.close_price , sph.volume ,  sph.trading_date  from endeavour.stocks_price_history sph limit 10";

    public List<StockPriceHistory> getAllStocks() {
        List<StockPriceHistory> stocks = new ArrayList<>();
//        String sql = "SELECT id, ticker_symbol, close_price, volume, date FROM STOCKS_PRICE_HISTORY";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY)) {

            while (rs.next()) {
                stocks.add(new StockPriceHistory(
                        rs.getString("ticker_symbol"),
                        rs.getDouble("close_price"),
                        rs.getLong("volume"),
                        rs.getString("trading_date")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stocks;
    }


}
