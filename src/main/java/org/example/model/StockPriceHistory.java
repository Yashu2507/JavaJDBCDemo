package org.example.model;

public class StockPriceHistory {

    private String ticker_symbol;
    private double close_price;
    private long volume;
    private String trading_date;

    public StockPriceHistory( String ticker_symbol, double close_price, long volume, String trading_date) {

        this.ticker_symbol = ticker_symbol;
        this.close_price = close_price;
        this.volume = volume;
        this.trading_date = trading_date;
    }



    public String getTickerSymbol() {
        return ticker_symbol;
    }

    public double getClosePrice() {
        return close_price;
    }

    public long getVolume() {
        return volume;
    }

    public String getDate() {
        return trading_date;
    }

    @Override
    public String toString() {
        return "StockPriceHistory{" +
                ", tickerSymbol='" + ticker_symbol + '\'' +
                ", closePrice=" + close_price +
                ", volume=" + volume +
                ", date='" + trading_date + '\'' +
                '}';
    }
}
