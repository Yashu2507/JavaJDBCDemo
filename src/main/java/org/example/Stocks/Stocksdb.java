package org.example.Stocks;

import java.sql.*;

public class Stocksdb {
    static final String DB_URL = "jdbc:postgresql://endeavourtech.ddns.net:50271/StocksDB";
    static final String USER = "evr_sql_app";
    static final String PASS = "5LViU5pLkSjRHECec9NF4wRxxV";
    static final String QUERY = "select sph.ticker_symbol ,sph.high_price ,sph.trading_date  from endeavour.stocks_price_history sph WHERE sph.high_price IS NOT NULL order by high_price desc limit 10";
    public static void main(String[] args){
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("TickerSymbol: " + rs.getString("ticker_symbol"));
                System.out.print(", high_price: " + rs.getDouble("high_price"));
                System.out.println(", trading_date: " + rs.getDate("trading_date"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
