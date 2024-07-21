package com.nishana.restaurantpos.controller;

import com.nishana.restaurantpos.dto.ApiResponse;
import com.nishana.restaurantpos.dto.RestaurantTableDTO;
import com.nishana.restaurantpos.service.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class RestaurantTableController {

    @Autowired
    private RestaurantTableService tableService;

    @PostMapping
    public ResponseEntity<ApiResponse<RestaurantTableDTO>> createTable(@RequestBody RestaurantTableDTO tableDTO) {
        RestaurantTableDTO createdTable = tableService.createTable(tableDTO);
        ApiResponse<RestaurantTableDTO> response = new ApiResponse<>("Table created successfully", createdTable);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<RestaurantTableDTO>> getTableById(@PathVariable Long id) {
        RestaurantTableDTO tableDTO = tableService.getTableById(id);
        ApiResponse<RestaurantTableDTO> response = new ApiResponse<>("Table retrieved successfully", tableDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<RestaurantTableDTO>>> getAllTables() {
        List<RestaurantTableDTO> tables = tableService.getAllTables();
        ApiResponse<List<RestaurantTableDTO>> response = new ApiResponse<>("Tables retrieved successfully", tables);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<RestaurantTableDTO>> updateTable(@PathVariable Long id, @RequestBody RestaurantTableDTO tableDTO) {
        RestaurantTableDTO updatedTable = tableService.updateTable(id, tableDTO);
        ApiResponse<RestaurantTableDTO> response = new ApiResponse<>("Table updated successfully", updatedTable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTable(@PathVariable Long id) {
        tableService.deleteTable(id);
        ApiResponse<Void> response = new ApiResponse<>("Table deleted successfully", null);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
}