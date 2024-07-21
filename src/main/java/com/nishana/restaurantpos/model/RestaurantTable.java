package com.nishana.restaurantpos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableId;

    @Column(name = "table_number", unique = true)
    private int tableNumber;

    private int capacity;

    @Enumerated(EnumType.STRING)
    private TableStatus status;

    private String location;

    private boolean isSmokingAllowed; // Field should be private but with Lombok @Data, getters and setters are auto-generated
}