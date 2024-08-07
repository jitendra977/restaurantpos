package com.nishana.restaurantpos.service;

import com.nishana.restaurantpos.dto.MenuItemDTO;

import java.util.List;

public interface MenuItemService {
    List<MenuItemDTO> getAllMenuItems();
    MenuItemDTO getMenuItemById(Long id);
    MenuItemDTO saveMenuItem(MenuItemDTO menuItemDTO);
    MenuItemDTO updateMenuItem(Long id, MenuItemDTO menuItemDTO);
    void deleteMenuItem(Long id);
}