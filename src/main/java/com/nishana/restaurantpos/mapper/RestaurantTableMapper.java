package com.nishana.restaurantpos.mapper;

import com.nishana.restaurantpos.dto.RestaurantTableDTO;
import com.nishana.restaurantpos.model.RestaurantTable;
import com.nishana.restaurantpos.model.TableStatus;

public class RestaurantTableMapper {

    public static RestaurantTableDTO toDTO(RestaurantTable table) {
        RestaurantTableDTO dto = new RestaurantTableDTO();
        dto.setTableId(table.getTableId());
        dto.setTableNumber(table.getTableNumber());
        dto.setCapacity(table.getCapacity());
        dto.setStatus(table.getStatus() != null ? table.getStatus().name() : null);
        dto.setLocation(table.getLocation());
        dto.setSmokingAllowed(table.isSmokingAllowed());
        return dto;
    }

    public static RestaurantTable toEntity(RestaurantTableDTO dto) {
        RestaurantTable table = new RestaurantTable();
        table.setTableId(dto.getTableId());
        table.setTableNumber(dto.getTableNumber());
        table.setCapacity(dto.getCapacity());
        table.setStatus(dto.getStatus() != null ? TableStatus.valueOf(dto.getStatus()) : null);
        table.setLocation(dto.getLocation());
        table.setSmokingAllowed(dto.isSmokingAllowed());
        return table;
    }
}