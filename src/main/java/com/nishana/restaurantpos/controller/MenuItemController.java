package com.nishana.restaurantpos.controller;

import com.nishana.restaurantpos.dto.ApiResponse;
import com.nishana.restaurantpos.dto.MenuItemDTO;
import com.nishana.restaurantpos.model.Category;
import com.nishana.restaurantpos.model.MenuItem;
import com.nishana.restaurantpos.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/")
    public ResponseEntity<List<MenuItem>> getMenuItem() {
        List<MenuItem> menuItemList = menuItemService.getMenuItem();
        return new ResponseEntity<>(menuItemList, HttpStatus.OK);
    }

    @GetMapping("/home")
    public String mainPage() {
        return "index"; // This will return the name of the HTML file (e.g., index.html) in your resources/templates directory
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getCategory() {
        List<Category> categories = menuItemService.getCategory();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> addMenuItem(@RequestBody MenuItemDTO menuItemDTO) {
        try {
            MenuItem menuItem = menuItemService.addMenuItem(menuItemDTO);
            return ResponseEntity.ok(new ApiResponse<>("Menu created successfully", menuItem));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(e.getMessage(), null));
        }
    }


    @PostMapping("/category")
    public ResponseEntity<ApiResponse<Category>> addCategory(@RequestBody Category category) {
        Category createdCategory = menuItemService.addCategory(category);
        ApiResponse<Category> response = new ApiResponse<>("Category created successfully", createdCategory);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteMenuItem(@PathVariable Long id) {
        menuItemService.deleteMenuItem(id);
        ApiResponse<String> response = new ApiResponse<>("Menu Item deleted successfully", "Deleted Menu Item with ID: " + id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
