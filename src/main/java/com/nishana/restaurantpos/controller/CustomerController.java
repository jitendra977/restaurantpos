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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @GetMapping("/")
    public ResponseEntity<List<Customer>> getCustomers(){
        List<Customer> customers = customerService.getCustomer();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    // add customer
    @PostMapping("/")
    public ResponseEntity<ApiResponse<Customer>> addCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.addCustomer(customer);
        ApiResponse<Customer> response = new ApiResponse<>("Customer created successfully", createdCustomer);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
