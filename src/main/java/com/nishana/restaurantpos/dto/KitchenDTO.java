package com.nishana.restaurantpos.dto;

import lombok.Data;

@Data
public class KitchenDTO {
    private Long id;
    private String name;
    private String location;
    private String status;

    // Getters and setters
}