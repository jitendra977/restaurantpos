package com.nishana.restaurantpos.serviceImpl;

import com.nishana.restaurantpos.dto.CategoryDTO;
import com.nishana.restaurantpos.exception.ResourceNotFoundException;
import com.nishana.restaurantpos.mapper.CategoryMapper;
import com.nishana.restaurantpos.model.Category;
import com.nishana.restaurantpos.repository.CategoryRepository;
import com.nishana.restaurantpos.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toEntity(categoryDTO);
        category = categoryRepository.save(category);
        return categoryMapper.toDTO(category);
    }

    @Override
    public CategoryDTO getCategoryById(Long Id) {
        Category category = categoryRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + Id));
        return categoryMapper.toDTO(category);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO updateCategory(Long Id, CategoryDTO categoryDTO) {
        // Find the existing category
        Category existingCategory = categoryRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + Id));

        // Update the existing category with values from categoryDTO
        existingCategory.setName(categoryDTO.getName());
        existingCategory.setDescription(categoryDTO.getDescription());

        // Save the updated category
        Category updatedCategory = categoryRepository.save(existingCategory);

        // Convert the updated category to DTO and return
        return categoryMapper.toDTO(updatedCategory);
    }

    @Override
    public void deleteCategory(Long Id) {
        Category category = categoryRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + Id));
        categoryRepository.delete(category);
    }
}