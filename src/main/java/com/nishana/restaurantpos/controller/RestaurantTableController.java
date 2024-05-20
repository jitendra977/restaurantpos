package com.nishana.restaurantpos.controller;

import com.nishana.restaurantpos.service.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nishana.restaurantpos.model.RestaurantTable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@RestController
@RequestMapping("/api/v1/restaurant-table")
public class RestaurantTableController {

    @Autowired
    private RestaurantTableService restaurantTableService;

    @GetMapping("/")
    public ResponseEntity<List<RestaurantTable>> getRestaurantTable() {
        List<RestaurantTable> tables = restaurantTableService.getRestaurantTable();
        return new ResponseEntity<>(tables, HttpStatus.OK);

    }   

    
}
