package com.nishana.restaurantpos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nishana.restaurantpos.dto.ApiResponse;
import com.nishana.restaurantpos.dto.OrderDTO;
import com.nishana.restaurantpos.model.Order;
import com.nishana.restaurantpos.service.OrderService;

@RestController
@RequestMapping("/api/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDTO>> getOrder() {
        List<OrderDTO> orders = orderService.getOrder();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<ApiResponse<OrderDTO>> addOrder(@RequestBody Order order) {
        OrderDTO createdOrder = orderService.addOrder(order);
        ApiResponse<OrderDTO> response = new ApiResponse<>("Order created successfully", createdOrder);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}