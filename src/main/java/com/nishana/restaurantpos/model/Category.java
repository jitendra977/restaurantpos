package com.nishana.restaurantpos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // If you want a bidirectional relationship, uncomment the following lines:
//     @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
//     private List<MenuItem> menuItems;
}
