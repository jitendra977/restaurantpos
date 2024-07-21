package com.nishana.restaurantpos.serviceImpl;

import com.nishana.restaurantpos.dto.RestaurantTableDTO;
import com.nishana.restaurantpos.exception.BadRequestException;
import com.nishana.restaurantpos.exception.ResourceNotFoundException;
import com.nishana.restaurantpos.mapper.RestaurantTableMapper;
import com.nishana.restaurantpos.model.RestaurantTable;
import com.nishana.restaurantpos.model.TableStatus;
import com.nishana.restaurantpos.repository.RestaurantTableRepository;
import com.nishana.restaurantpos.service.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantTableServiceImpl implements RestaurantTableService {

    @Autowired
    private RestaurantTableRepository tableRepository;

    @Override
    public RestaurantTableDTO createTable(RestaurantTableDTO tableDTO) {
        // Check if a table with the same number already exists
        if (tableRepository.existsByTableNumber(tableDTO.getTableNumber())) {
            throw new BadRequestException("Table number already exists");
        }
        // Convert DTO to Entity
        RestaurantTable table = RestaurantTableMapper.toEntity(tableDTO);
        // Save the entity and convert it back to DTO
        return RestaurantTableMapper.toDTO(tableRepository.save(table));
    }

    @Override
    public RestaurantTableDTO getTableById(Long id) {
        // Find the table by ID or throw an exception if not found
        RestaurantTable table = tableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Table not found"));
        // Convert Entity to DTO
        return RestaurantTableMapper.toDTO(table);
    }

    @Override
    public List<RestaurantTableDTO> getAllTables() {
        // Find all tables, convert each to DTO, and collect them into a list
        return tableRepository.findAll().stream()
                .map(RestaurantTableMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantTableDTO updateTable(Long id, RestaurantTableDTO tableDTO) {
        // Check if a table with the same number exists (except for the current one)
        if (tableRepository.existsByTableNumberAndTableIdNot(tableDTO.getTableNumber(), id)) {
            throw new BadRequestException("Table number already exists");
        }
        // Find the table by ID or throw an exception if not found
        RestaurantTable table = tableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Table not found"));
        // Update table fields
        table.setTableNumber(tableDTO.getTableNumber());
        table.setCapacity(tableDTO.getCapacity());
        table.setStatus(TableStatus.valueOf(tableDTO.getStatus()));
        table.setLocation(tableDTO.getLocation());
        table.setSmokingAllowed(tableDTO.isSmokingAllowed());
        // Save the updated entity and convert it back to DTO
        return RestaurantTableMapper.toDTO(tableRepository.save(table));
    }

    @Override
    public void deleteTable(Long id) {
        // Check if the table exists before attempting to delete
        if (!tableRepository.existsById(id)) {
            throw new ResourceNotFoundException("Table not found");
        }
        // Delete the table by ID
        tableRepository.deleteById(id);
    }
}