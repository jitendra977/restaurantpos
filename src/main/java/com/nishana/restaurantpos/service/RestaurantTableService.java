package com.nishana.restaurantpos.service;

import com.nishana.restaurantpos.model.RestaurantTable;

import java.util.List;
import java.util.Optional;

public interface RestaurantTableService {
    public List<RestaurantTable> getRestaurantTable();

    public RestaurantTable saveTable(RestaurantTable table);

    public Optional<RestaurantTable> getTableById(Long id);

    public RestaurantTable updateTable(Long id, RestaurantTable table);

    public void deleteTable(Long id);
}
