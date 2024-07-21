package com.nishana.restaurantpos.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private LocalDateTime orderDate;
    private float totalAmount;
    private String status;
    private RestaurantTableDTO table;
    private UserDTO user;
    private PaymentMethodDTO paymentMethod;
    private KitchenDTO kitchen;
    private List<OrderItemDTO> orderItems;

    // Getters and setters
}