package com.nishana.restaurantpos.controller;

import com.nishana.restaurantpos.dto.ApiResponse;
import com.nishana.restaurantpos.dto.MenuItemDTO;
import com.nishana.restaurantpos.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu-items")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @PostMapping
    public ResponseEntity<ApiResponse<MenuItemDTO>> createMenuItem(@RequestBody MenuItemDTO menuItemDTO) {
        MenuItemDTO createdMenuItem = menuItemService.saveMenuItem(menuItemDTO);
        ApiResponse<MenuItemDTO> response = new ApiResponse<>("Menu Item Created Successfully", createdMenuItem);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<MenuItemDTO>> getMenuItemById(@PathVariable Long id) {
        MenuItemDTO menuItemDTO = menuItemService.getMenuItemById(id);
        ApiResponse<MenuItemDTO> response = new ApiResponse<>("Menu Item with id: " + id, menuItemDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<MenuItemDTO>> getAllMenuItems() {
        List<MenuItemDTO> menuItemDTOS = menuItemService.getAllMenuItems();
        return ResponseEntity.ok(menuItemDTOS);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<MenuItemDTO>> updateMenuItem(@PathVariable Long id, @RequestBody MenuItemDTO menuItemDTO) {
        MenuItemDTO updatedMenuItem = menuItemService.updateMenuItem(id, menuItemDTO);
        ApiResponse<MenuItemDTO> response = new ApiResponse<>("Menu Item updated successfully with id: " + id, updatedMenuItem);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteMenuItem(@PathVariable Long id) {
        menuItemService.deleteMenuItem(id);
        ApiResponse<String> response = new ApiResponse<>("Menu Item Deleted Successfully with Id: " + id, "Deleted Menu Item with Id: " + id);
        return ResponseEntity.ok(response);
    }
}