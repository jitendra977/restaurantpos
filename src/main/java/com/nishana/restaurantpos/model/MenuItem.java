package com.nishana.restaurantpos.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private String name;
    private String description;
    private float price;
    private String availability;
    @ManyToOne
    private Category category;
}
