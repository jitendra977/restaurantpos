package com.nishana.restaurantpos.service;

import java.util.List;

import com.nishana.restaurantpos.model.Order;

public interface OrderService {
    public List<Order> getOrder();

    public Order addOrder(Order order);
    
}
