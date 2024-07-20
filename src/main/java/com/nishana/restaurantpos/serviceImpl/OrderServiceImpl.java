package com.nishana.restaurantpos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishana.restaurantpos.model.Order;
import com.nishana.restaurantpos.repository.OrderRepository;
import com.nishana.restaurantpos.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Order> getOrder() {
       return orderRepository.findAll();
    }
    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

}
