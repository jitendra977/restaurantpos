package com.nishana.restaurantpos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Kitchen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String status;


//    @OneToMany(mappedBy = "kitchen", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Order> orders;
}