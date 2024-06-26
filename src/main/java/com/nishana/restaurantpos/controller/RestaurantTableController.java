package com.nishana.restaurantpos.controller;

import com.nishana.restaurantpos.dto.ApiResponse;
import com.nishana.restaurantpos.service.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.nishana.restaurantpos.model.RestaurantTable;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/restaurant-table")
@CrossOrigin(origins = "http://localhost:5173")
public class RestaurantTableController {

    @Autowired
    private RestaurantTableService restaurantTableService;


    @GetMapping("/")
    public ResponseEntity<List<RestaurantTable>> getRestaurantTable() {
        List<RestaurantTable> tables = restaurantTableService.getRestaurantTable();
        return new ResponseEntity<>(tables, HttpStatus.OK);


    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<RestaurantTable>> getTableById(@PathVariable("id") Long id){
        Optional<RestaurantTable> table = restaurantTableService.getTableById(id);
        return new ResponseEntity<Optional <RestaurantTable>>(table,HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<RestaurantTable> createTable(@RequestBody RestaurantTable table){
        RestaurantTable createdTable = restaurantTableService.saveTable(table);
        return new ResponseEntity<>(createdTable,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<RestaurantTable>> updateTable(@PathVariable("id") Long id, @RequestBody RestaurantTable table) {
        RestaurantTable updatedTable = restaurantTableService.updateTable(id, table);
        ApiResponse<RestaurantTable> response = new ApiResponse<>("Table Has Been Update",updatedTable);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable("id")Long id ){
        restaurantTableService.deleteTable(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}
