package com.nishana.restaurantpos.mapper;

import com.nishana.restaurantpos.dto.MenuItemDTO;
import com.nishana.restaurantpos.model.MenuItem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuItemMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public MenuItemMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public MenuItemDTO toDto(MenuItem menuItem){
        return modelMapper.map(menuItem,MenuItemDTO.class);
    }

    public MenuItem toEntity(MenuItemDTO menuItemDTO){
        return modelMapper.map(menuItemDTO,MenuItem.class);
    }


}
