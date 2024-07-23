package com.nishana.restaurantpos.service;

import com.nishana.restaurantpos.dto.OrderDTO;
import com.nishana.restaurantpos.model.Order;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getOrder();
    OrderDTO addOrder(Order order);
    OrderDTO getOrderById(Long id);
    OrderDTO updateOrder(Long id, Order orderDetails);
    void deleteOrder(Long id);
}