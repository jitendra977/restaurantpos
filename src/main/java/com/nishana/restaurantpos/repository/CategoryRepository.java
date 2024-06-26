package com.nishana.restaurantpos.repository;

import com.nishana.restaurantpos.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category ,Long> {

}
