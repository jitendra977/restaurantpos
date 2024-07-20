package com.nishana.restaurantpos.dto;

import lombok.Data;

@Data
public class MenuItemDTO {
    private String name;
    private String description;
    private double price;
    private Long categoryId;
    
}
