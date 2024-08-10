package com.nishana.restaurantpos.dto;

import lombok.Data;

@Data
public class MenuItemDTO {
    private int itemId;
    private String name;
    private String description;
    private double price;
    private Long categoryId;
    private String categoryName;
    private String availability;
    
}
