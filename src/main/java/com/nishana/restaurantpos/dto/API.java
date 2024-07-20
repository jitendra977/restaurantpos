package com.nishana.restaurantpos.dto;


public class API {
    private String name;
    private String description;
    private String endpoint;

    public API(String name, String description, String endpoint) {
        this.name = name;
        this.description = description;
        this.endpoint = endpoint;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
