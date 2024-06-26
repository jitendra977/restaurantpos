package com.nishana.restaurantpos.service;

import com.nishana.restaurantpos.dto.MenuItemDTO;
import com.nishana.restaurantpos.model.Category;
import com.nishana.restaurantpos.model.MenuItem;

import java.util.List;

public interface MenuItemService {
    List<MenuItem> getMenuItem();
    MenuItem addMenuItem(MenuItemDTO menuItemDTO);
    void deleteMenuItem(Long id);
    List<Category> getCategory();
    Category addCategory(Category category);
}
