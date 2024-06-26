package com.nishana.restaurantpos.controller;

import com.nishana.restaurantpos.dto.ApiResponse;
import com.nishana.restaurantpos.model.Customer;
import com.nishana.restaurantpos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Get all customers
    @GetMapping("/")
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customers = customerService.getCustomer();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // Add a new customer
    @PostMapping("/")
    public ResponseEntity<ApiResponse<Customer>> addCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.addCustomer(customer);
        ApiResponse<Customer> response = new ApiResponse<>("Customer created successfully", createdCustomer);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Delete a customer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        ApiResponse<String> response = new ApiResponse<>("Customer deleted successfully", "Deleted customer with ID: " + id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
