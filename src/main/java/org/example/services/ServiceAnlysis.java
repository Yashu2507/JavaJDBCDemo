package org.example.services;

import java.sql.*;

public class ServiceAnlysis {
    static final String DB_URL = "jdbc:postgresql://endeavourtech.ddns.net:50271/StocksDB";
    static final String USER = "evr_sql_app";
    static final String PASS = "5LViU5pLkSjRHECec9NF4wRxxV";

    static final String QUERY =
            "select sl.sector_name, count(sf.ticker_symbol) AS stock_count " +
                    "from endeavour.sector_lookup sl " +
                    "join endeavour.stock_fundamentals sf on sl.sector_id = sf.sector_id " +
                    "group by sl.sector_name " +
                    "order by stock_count desc";

    public void displaySectorWiseStockCount() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY)) {

            System.out.println("Sector Name | Number of Stocks");
            System.out.println("-------------------------------");

            while (rs.next()) {
                System.out.println(rs.getString("sector_name") + " | " +
                        rs.getInt("stock_count"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
