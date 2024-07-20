package com.nishana.restaurantpos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String methodName;

    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.PERSIST)
    private List<Order> orders;
}