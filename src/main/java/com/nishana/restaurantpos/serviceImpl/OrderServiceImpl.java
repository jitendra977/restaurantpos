package com.nishana.restaurantpos.serviceImpl;

import com.nishana.restaurantpos.dto.OrderDTO;
import com.nishana.restaurantpos.exception.ResourceNotFoundException;
import com.nishana.restaurantpos.mapper.OrderMapper;
import com.nishana.restaurantpos.model.MenuItem;
import com.nishana.restaurantpos.model.Order;
import com.nishana.restaurantpos.model.OrderItem;
import com.nishana.restaurantpos.repository.MenuItemRepository;
import com.nishana.restaurantpos.repository.OrderRepository;
import com.nishana.restaurantpos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private  MenuItemRepository menuItemRepository;

    @Override
    public List<OrderDTO> getOrder() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(OrderMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public OrderDTO addOrder(Order order) {
        float totalAmount = 0.0f;

        if (order.getOrderItems() != null) {
            for (OrderItem item : order.getOrderItems()) {
                // Fetch MenuItem from repository using itemId
                MenuItem menuItem = menuItemRepository.findById(item.getMenuItem().getItemId())
                        .orElseThrow(() -> new ResourceNotFoundException("MenuItem not found for this id :: " + item.getMenuItem().getItemId()));

                // Set the price from MenuItem
                item.setPrice(menuItem.getPrice());
                item.setOrder(order); // Set the order reference

                // Calculate total amount
                totalAmount += item.getPrice() * item.getQuantity();
            }
        }

        order.setTotalAmount(totalAmount);
        Order savedOrder = orderRepository.save(order);
        return OrderMapper.convertToDTO(savedOrder);
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + id));
        return OrderMapper.convertToDTO(order);
    }

    @Override
    public OrderDTO updateOrder(Long id, Order orderDetails) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + id));

        order.setOrderDate(orderDetails.getOrderDate());
        order.setTotalAmount(orderDetails.getTotalAmount());
        order.setStatus(orderDetails.getStatus());

        if (orderDetails.getOrderItems() != null) {
            for (OrderItem item : orderDetails.getOrderItems()) {
                item.setOrder(order);
            }
        }

        Order updatedOrder = orderRepository.save(order);
        return OrderMapper.convertToDTO(updatedOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + id));
        orderRepository.delete(order);
    }
}