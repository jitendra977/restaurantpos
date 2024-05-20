package com.nishana.restaurantpos.serviceImpl;

import com.nishana.restaurantpos.model.RestaurantTable;
import com.nishana.restaurantpos.repository.RestaurantTableRepository;
import com.nishana.restaurantpos.service.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantTableServiceImpl implements RestaurantTableService {
    @Autowired
    private RestaurantTableRepository restaurantTableRepository;

    @Override
    public List<RestaurantTable> getRestaurantTable() {
       return restaurantTableRepository.findAll();
    }
}
