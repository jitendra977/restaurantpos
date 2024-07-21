package com.nishana.restaurantpos.service;

import com.nishana.restaurantpos.dto.RestaurantTableDTO;

import java.util.List;

public interface RestaurantTableService {
    RestaurantTableDTO createTable(RestaurantTableDTO tableDTO);
    RestaurantTableDTO getTableById(Long id);
    List<RestaurantTableDTO> getAllTables();
    RestaurantTableDTO updateTable(Long id, RestaurantTableDTO tableDTO);
    void deleteTable(Long id);
}