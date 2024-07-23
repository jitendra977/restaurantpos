package com.nishana.restaurantpos.controller;

import com.nishana.restaurantpos.dto.ApiResponse;
import com.nishana.restaurantpos.dto.OrderDTO;
import com.nishana.restaurantpos.model.Order;
import com.nishana.restaurantpos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getOrders() {
        List<OrderDTO> orders = orderService.getOrder();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        OrderDTO orderDTO = orderService.getOrderById(id);
        return ResponseEntity.ok(orderDTO);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<OrderDTO>> addOrder(@RequestBody Order order) {
        OrderDTO createdOrder = orderService.addOrder(order);
        ApiResponse<OrderDTO> response = new ApiResponse<>("Order created successfully", createdOrder);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<OrderDTO>> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        OrderDTO updatedOrder = orderService.updateOrder(id, orderDetails);
        ApiResponse<OrderDTO> response = new ApiResponse<>("Order updated successfully", updatedOrder);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        ApiResponse<Void> response = new ApiResponse<>("Order deleted successfully", null);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
}