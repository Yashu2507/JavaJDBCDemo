package org.example.vo;

public class StocksFundamentals{
     private String ticker_symbol;
     String ticker_name;
     int sector_id;
     double market_cap;
     double current_ratio;

    public StocksFundamentals(String ticker_symbol,String ticker_name, double current_ratio, double market_cap, int sector_id) {
        this.ticker_symbol = ticker_symbol;
        this.ticker_name = ticker_name;
        this.current_ratio = current_ratio;
        this.market_cap = market_cap;
        this.sector_id = sector_id;
    }

    @Override
    public String toString() {
        return "StocksFundamentals{" +
                "ticker_symbol='" + ticker_symbol + '\'' +
                "ticker_name='" + ticker_name + '\'' +
                ", sector_id=" + sector_id +
                ", market_cap=" + market_cap +
                ", current_ratio=" + current_ratio +
                '}';
    }
}
