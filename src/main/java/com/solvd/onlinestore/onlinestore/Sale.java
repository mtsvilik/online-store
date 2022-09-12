package com.solvd.onlinestore.onlinestore;

public enum Sale {

    SEVENTY_PERCENT("SALE 70%"),
    FIFTY_PERCENT("SALE 50%"),
    FORTY_PERCENT("SALE 40%"),
    TWENTY_PERCENT("SALE 20$");

    private String title;

    Sale(String title) {
        this.title = title;
    }
}