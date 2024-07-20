package com.nishana.restaurantpos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nishana.restaurantpos.dto.ApiResponse;
import com.nishana.restaurantpos.model.Customer;
import com.nishana.restaurantpos.model.Order;
import com.nishana.restaurantpos.service.OrderService;




@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping()
    public ResponseEntity<List<Order>> getOrder() {
        List<Order> order = orderService.getOrder();
        return new ResponseEntity<>(order, HttpStatus.OK);
    }


    // Add a new customer
    @PostMapping()
    public ResponseEntity<ApiResponse<Order>> addOrder(@RequestBody Order order) {
        Order createdOrder = orderService.addOrder(order);
        ApiResponse<Order> response = new ApiResponse<>("Order created successfully", createdOrder);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
