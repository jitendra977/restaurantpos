package com.nishana.restaurantpos.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "table_number", unique = true)
    private int tableNumber;

    private int capacity;

    @Enumerated(EnumType.STRING)
    private TableStatus status;

    private String location;

    private boolean isSmokingAllowed;


}
