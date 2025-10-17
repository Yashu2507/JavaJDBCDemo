package org.example.services;

import org.example.vo.StocksFundamentals;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockFundamentalsService {
    static final String DB_URL = "jdbc:postgresql://endeavourtech.ddns.net:50271/StocksDB";
    static final String USER = "evr_sql_app";
    static final String PASS = "5LViU5pLkSjRHECec9NF4wRxxV";

    static final String QUERY = """
        select sl.ticker_name, sf.ticker_symbol, sf.sector_id, sf.market_cap, sf.current_ratio
        from endeavour.stock_fundamentals sf
        join endeavour.stocks_lookup sl on sf.ticker_symbol = sl.ticker_symbol
    """;

    public List<StocksFundamentals> getStockFundamentals() {
        List<StocksFundamentals> sfds = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY)) {

            while (rs.next()) {
                StocksFundamentals sfd = new StocksFundamentals(
                        rs.getString("ticker_symbol"),
                        rs.getString("ticker_name"),
                        rs.getDouble("current_ratio"),
                        rs.getDouble("market_cap"),
                        rs.getInt("sector_id")
                );
                sfds.add(sfd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sfds;
    }
}