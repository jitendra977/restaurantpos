package com.nishana.restaurantpos.serviceImpl;

import com.nishana.restaurantpos.model.RestaurantTable;
import com.nishana.restaurantpos.model.TableStatus;
import com.nishana.restaurantpos.repository.RestaurantTableRepository;
import com.nishana.restaurantpos.service.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class RestaurantTableServiceImpl implements RestaurantTableService {
    @Autowired
    private RestaurantTableRepository restaurantTableRepository;

    //get all table
    @Override
    public List<RestaurantTable> getRestaurantTable() {
       return restaurantTableRepository.findAll();
    }
    //save the table
    @Override
    public RestaurantTable saveTable(RestaurantTable table) {
        if (table.getStatus()==null){
            table.setStatus(TableStatus.AVAILABLE);
        }
        return restaurantTableRepository.save(table);
    }
    // get table by id
    @Override
    public Optional<RestaurantTable> getTableById(Long id) {
        return restaurantTableRepository.findById(id);
    }
    // update table by id
    @Override
    public RestaurantTable updateTable(Long id, RestaurantTable updatedTable) {
        // Find the existing table by ID
        RestaurantTable existingTable = restaurantTableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Table not found with id: " + id));

        // Update the table details

        existingTable.setCapacity(updatedTable.getCapacity());
        existingTable.setLocation(updatedTable.getLocation());
        existingTable.setStatus(updatedTable.getStatus());
        existingTable.setSmokingAllowed(updatedTable.isSmokingAllowed());

        // Save the updated table
        return restaurantTableRepository.save(existingTable);
    }

    @Override
    public void deleteTable(Long id) {
        restaurantTableRepository.deleteById(id);
    }


}
