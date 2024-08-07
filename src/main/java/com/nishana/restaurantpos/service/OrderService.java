package com.nishana.restaurantpos.service;

import java.util.List;

import com.nishana.restaurantpos.dto.OrderDTO;
import com.nishana.restaurantpos.model.Order;

public interface OrderService {
    public List<OrderDTO> getOrder();

    public OrderDTO addOrder(Order order);
    
}
