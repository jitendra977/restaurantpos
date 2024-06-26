package com.nishana.restaurantpos.serviceImpl;

import com.nishana.restaurantpos.exception.ResourceNotFoundException;
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
        try{
            if (table.getStatus()==null){
                table.setStatus(TableStatus.AVAILABLE);
            }
        }
        catch (Exception e){
            System.out.println("something error");
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
    public RestaurantTable updateTable(Long id, RestaurantTable table) {
        return restaurantTableRepository.findById(id).map(existingTable -> {
            existingTable.setCapacity(table.getCapacity());
            existingTable.setLocation(table.getLocation());
            existingTable.setStatus(table.getStatus());
            existingTable.setSmokingAllowed(table.isSmokingAllowed());
            return restaurantTableRepository.save(existingTable);
        }).orElseThrow(() -> new ResourceNotFoundException("Table with id " + id + " not found"));

    }

    @Override
    public void deleteTable(Long id) {
        restaurantTableRepository.deleteById(id);
    }


}
