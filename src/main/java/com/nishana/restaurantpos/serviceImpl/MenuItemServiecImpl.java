package com.nishana.restaurantpos.serviceImpl;

import com.nishana.restaurantpos.dto.MenuItemDTO;
import com.nishana.restaurantpos.exception.BadRequestException;
import com.nishana.restaurantpos.exception.ResourceNotFoundException;
import com.nishana.restaurantpos.model.Category;
import com.nishana.restaurantpos.model.MenuItem;
import com.nishana.restaurantpos.repository.CategoryRepository;
import com.nishana.restaurantpos.repository.MenuItemRepository;
import com.nishana.restaurantpos.service.MenuItemService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuItemServiecImpl implements MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<MenuItem> getMenuItem() {

        return menuItemRepository.findAll();
    }

    @Override
    @Transactional
    public MenuItem addMenuItem(MenuItemDTO menuItemDTO) {
        MenuItem menuItem = new MenuItem();
        menuItem.setName(menuItemDTO.getName());
        menuItem.setDescription(menuItemDTO.getDescription());
        menuItem.setPrice(menuItemDTO.getPrice());

        Optional<Category> categoryOptional = categoryRepository.findById(menuItemDTO.getCategoryId());
        if (categoryOptional.isPresent()) {
            menuItem.setCategory(categoryOptional.get());
        } else {
            throw new RuntimeException("Category not found for id: " + menuItemDTO.getCategoryId());
        }

        return menuItemRepository.save(menuItem);
    }

    @Override
    @Transactional
    public void deleteMenuItem(Long id) {
        Optional<MenuItem> menuItemOptional = menuItemRepository.findById(id);
        if(menuItemOptional.isEmpty()){
            throw new ResourceNotFoundException("menu item not found with id"+id);

        }
        menuItemRepository.deleteById(id);
    }

    @Override
    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public Category addCategory(Category category) {
        if(category == null|| category.getName() == null || category.getName().trim().isEmpty()){
            throw  new BadRequestException("category can not be null");
        }
        return categoryRepository.save(category);
    }


}
