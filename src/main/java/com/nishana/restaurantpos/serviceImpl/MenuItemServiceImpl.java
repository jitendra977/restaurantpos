package com.nishana.restaurantpos.serviceImpl;

import com.nishana.restaurantpos.dto.MenuItemDTO;
import com.nishana.restaurantpos.exception.ResourceNotFoundException;
import com.nishana.restaurantpos.mapper.MenuItemMapper;
import com.nishana.restaurantpos.model.MenuItem;
import com.nishana.restaurantpos.repository.MenuItemRepository;
import com.nishana.restaurantpos.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private MenuItemMapper menuItemMapper;

    @Override
    public MenuItemDTO saveMenuItem(MenuItemDTO menuItemDTO) {
        MenuItem menuItem = menuItemMapper.toEntity(menuItemDTO);
        menuItem = menuItemRepository.save(menuItem);
        return menuItemMapper.toDto(menuItem);
    }

    @Override
    public MenuItemDTO getMenuItemById(Long menuItemId) {
        MenuItem menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu item not found with id: " + menuItemId));
        return menuItemMapper.toDto(menuItem);
    }

    @Override
    public List<MenuItemDTO> getAllMenuItems() {
        List<MenuItem> menuItems = menuItemRepository.findAll();
        return menuItems.stream()
                .map(menuItemMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MenuItemDTO updateMenuItem(Long menuItemId, MenuItemDTO menuItemDTO) {
        MenuItem existingMenuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu item not found with id: " + menuItemId));

        MenuItem menuItem = menuItemMapper.toEntity(menuItemDTO);
        menuItem.setItemId(existingMenuItem.getItemId()); // ensure the ID remains the same
        menuItem = menuItemRepository.save(menuItem);
        return menuItemMapper.toDto(menuItem);
    }

    @Override
    public void deleteMenuItem(Long menuItemId) {
        MenuItem menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu item not found with id: " + menuItemId));
        menuItemRepository.delete(menuItem);
    }
}