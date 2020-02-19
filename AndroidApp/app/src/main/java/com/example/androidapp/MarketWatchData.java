package com.example.androidapp;

public class MarketWatchData {

    String symbol;
    String close;
    String value;

    public MarketWatchData(String symbol, String close, String value) {

        this.symbol = symbol.substring(3, 6);
        this.close = close;
        this.value = String.format("%x", value);
    }

    public String getSymbol() {
        return symbol;
    }

    public String getClose() {
        return close;
    }

    public String getValue() {
        return value;
    }

}
