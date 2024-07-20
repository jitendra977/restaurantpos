package com.nishana.restaurantpos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nishana.restaurantpos.model.RestaurantTable;
@Repository
public interface TableRepository extends JpaRepository<RestaurantTable, Long> {
    // You can add custom query methods here if needed
}
