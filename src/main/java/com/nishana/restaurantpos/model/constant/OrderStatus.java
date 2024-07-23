package com.nishana.restaurantpos.model.constant;


public enum OrderStatus {
    PENDING("PENDING"),
    IN_PROGRESS("IN_PROGRESS"),
    READY_FOR_PICKUP("READY_FOR_PICKUP"),
    DELIVERED("DELIVERED"),
    CANCELED("CANCELED");

    private final String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}