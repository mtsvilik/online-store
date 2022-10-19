package com.solvd.onlinestore.domain.book;

public enum DeliveryType {

    BY_COURIER("Delivery by courier"),
    BY_MAIL("Delivery by mail");

    private String name;

    DeliveryType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
