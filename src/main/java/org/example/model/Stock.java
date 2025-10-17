package org.example.model;

public class Stock {
    private String ticker_symbol;
    private String ticker_name;
    private int sector_id;
    private double market_cap;
    private double current_ratio;

    public Stock(String ticker_symbol, String ticker_name, double market_cap, double current_ratio) {
        this.ticker_symbol = ticker_symbol;
        this.ticker_name = ticker_name;
        this.market_cap = market_cap;
        this.current_ratio = current_ratio;
    }

    public String getTicker_symbol() {
        return ticker_symbol;
    }
    public String getTicker_name() {
        return ticker_name;
    }

    public int getSector_id() {
        return sector_id;
    }

    public void setSector_id(int sector_id) {
        this.sector_id = sector_id;
    }

    public double getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(double market_cap) {
        this.market_cap = market_cap;
    }

    public double getCurrent_ratio() {
        return current_ratio;
    }

    public void setCurrent_ratio(double current_ratio) {
        this.current_ratio = current_ratio;
    }
}
