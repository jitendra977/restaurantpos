package com.nishana.restaurantpos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;  // Reference to the Order entity

    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;  // Reference to the MenuItem entity
}