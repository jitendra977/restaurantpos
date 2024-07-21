package com.nishana.restaurantpos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemDTO {
    private Long id;
    private int quantity;
    private double price;
    private Long orderId;  // Add this field to store the associated order ID
    private MenuItemDTO menuItem;  // Assuming you have a MenuItemDTO
}