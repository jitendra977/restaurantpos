package com.nishana.restaurantpos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableId; // Changed field name to tableId

    @Column(name = "table_number", unique = true)
    private int tableNumber;

    private int capacity;

    @Enumerated(EnumType.STRING)
    private TableStatus status;

    private String location;

    private boolean isSmokingAllowed;

    @OneToMany(mappedBy = "table")
    private List<Order> orders;
}
