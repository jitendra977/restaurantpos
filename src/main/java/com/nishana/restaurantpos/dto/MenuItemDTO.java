package com.nishana.restaurantpos.dto;

import lombok.Data;

@Data
public class MenuItemDTO {
    private Long itemId;
    private String name;
    private String description;
    private float price; // Ensure this is present
    private Long categoryId;
}