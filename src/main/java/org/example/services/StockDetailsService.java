package org.example.services;

import java.sql.*;

public class StockDetailsService {
    static final String DB_URL = "jdbc:postgresql://endeavourtech.ddns.net:50271/StocksDB";
    static final String USER = "evr_sql_app";
    static final String PASS = "5LViU5pLkSjRHECec9NF4wRxxV";

    static final String QUERY =
            "select sl.ticker_symbol, " +
                    "       sl.ticker_name, " +
                    "       sec.sector_name, " +
                    "       sub.subsector_name, " +
                    "       sf.market_cap, " +
                    "       sf.current_ratio " +
                    "from endeavour.stocks_lookup sl " +
                    "join endeavour.stock_fundamentals sf ON sl.ticker_symbol = sf.ticker_symbol " +
                    "join endeavour.subsector_lookup sub ON sf.subsector_id = sub.subsector_id " +
                    "join endeavour.sector_lookup sec ON sub.sector_id = sec.sector_id " +
                    "where sl.ticker_symbol = ?;";

    public void displayStockDetails(String ticker) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(QUERY)) {

            ps.setString(1, ticker);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Ticker: " + rs.getString("ticker_symbol"));
                System.out.println("Name: " + rs.getString("ticker_name"));
                System.out.println("Sector: " + rs.getString("sector_name"));
                System.out.println("Subsector: " + rs.getString("subsector_name"));
                System.out.println("Market Cap: " + rs.getDouble("market_cap"));
                System.out.println("Current Ratio: " + rs.getDouble("current_ratio"));
            } else {
                System.out.println("No data found for ticker: " + ticker);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
