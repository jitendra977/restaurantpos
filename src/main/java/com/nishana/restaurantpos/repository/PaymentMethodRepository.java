package com.nishana.restaurantpos.repository;

import com.nishana.restaurantpos.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository <PaymentMethod,Long> {
}
