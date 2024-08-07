package com.nishana.restaurantpos.service;

import com.nishana.restaurantpos.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO getCategoryById(Long Id);
    List<CategoryDTO> getAllCategory();
    CategoryDTO updateCategory(Long Id ,CategoryDTO categoryDTO);
    void deleteCategory(Long Id);
}
