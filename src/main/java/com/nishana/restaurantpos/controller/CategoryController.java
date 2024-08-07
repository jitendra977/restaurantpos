package com.nishana.restaurantpos.controller;


import com.nishana.restaurantpos.dto.ApiResponse;
import com.nishana.restaurantpos.dto.CategoryDTO;
import com.nishana.restaurantpos.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryDTO>> createCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO createdCategory = categoryService.createCategory(categoryDTO);
        ApiResponse<CategoryDTO> response = new ApiResponse<>("Category Created Successfully",createdCategory);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<ApiResponse<CategoryDTO>> getCategoryById(@PathVariable Long Id) {
        CategoryDTO categoryDTO = categoryService.getCategoryById(Id);
        ApiResponse<CategoryDTO> response = new ApiResponse<>("Category with id: " + Id, categoryDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public  ResponseEntity<List<CategoryDTO>> getAllCategory(){
        List<CategoryDTO> categoryDTOS = categoryService.getAllCategory();
        return ResponseEntity.ok(categoryDTOS);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<ApiResponse<CategoryDTO>> updateCategory(@PathVariable Long Id, @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO updatedCategory = categoryService.updateCategory(Id, categoryDTO);
        ApiResponse<CategoryDTO> response = new ApiResponse<>("Category updated successfully with id : "+Id, updatedCategory);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<ApiResponse<CategoryDTO>> deleteCategory(@PathVariable Long Id){
        CategoryDTO categoryDTO = categoryService.getCategoryById(Id);
       categoryService.deleteCategory(Id);
       ApiResponse<CategoryDTO> response = new ApiResponse<>("Category Delete Successfully with Id " +Id,categoryDTO);
       return ResponseEntity.ok(response);
    }

}
