package com.nishana.restaurantpos.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String name;
    private String contact_number;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
