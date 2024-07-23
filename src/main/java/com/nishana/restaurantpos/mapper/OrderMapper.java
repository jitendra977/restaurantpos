package com.nishana.restaurantpos.mapper;

import com.nishana.restaurantpos.dto.*;
import com.nishana.restaurantpos.model.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderDTO convertToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setTotalAmount(order.getTotalAmount());
        orderDTO.setStatus(order.getStatus().name());

        // Handle potential null values for RestaurantTable
        RestaurantTableDTO tableDTO = new RestaurantTableDTO();
        if (order.getTable() != null) {
            tableDTO.setTableId(order.getTable().getTableId());
            tableDTO.setTableNumber(order.getTable().getTableNumber());
            tableDTO.setCapacity(order.getTable().getCapacity());
            tableDTO.setStatus(order.getTable().getStatus() != null ? order.getTable().getStatus().name() : "UNKNOWN");
            tableDTO.setLocation(order.getTable().getLocation());
            tableDTO.setSmokingAllowed(order.getTable().isSmokingAllowed());
        }
        orderDTO.setTable(tableDTO);

        // Handle potential null values for User
        UserDTO userDTO = new UserDTO();
        if (order.getUser() != null) {
            userDTO.setUserId(order.getUser().getUserId());
            userDTO.setName(order.getUser().getName());
            userDTO.setContactNumber(order.getUser().getContactNumber());
            userDTO.setEmail(order.getUser().getEmail());
        }
        orderDTO.setUser(userDTO);

        // Handle potential null values for PaymentMethod
        PaymentMethodDTO paymentMethodDTO = new PaymentMethodDTO();
        if (order.getPaymentMethod() != null) {
            paymentMethodDTO.setId(order.getPaymentMethod().getId());
            paymentMethodDTO.setMethodName(order.getPaymentMethod().getMethodName());
        }
        orderDTO.setPaymentMethod(paymentMethodDTO);

        // Handle potential null values for Kitchen
        KitchenDTO kitchenDTO = new KitchenDTO();
        if (order.getKitchen() != null) {
            kitchenDTO.setId(order.getKitchen().getId());
            kitchenDTO.setName(order.getKitchen().getName());
            kitchenDTO.setLocation(order.getKitchen().getLocation());
            kitchenDTO.setStatus(order.getKitchen().getStatus());
        }
        orderDTO.setKitchen(kitchenDTO);

        // Handle potential null values for OrderItems
        List<OrderItemDTO> orderItemDTOs = order.getOrderItems().stream().map(item -> {
            OrderItemDTO itemDTO = new OrderItemDTO();
            itemDTO.setId(item.getId());
            itemDTO.setQuantity(item.getQuantity());
            itemDTO.setPrice(item.getPrice());
            itemDTO.setOrderId(order.getId());  // Set the orderId here
            // You need to create and set MenuItemDTO here if available
            // itemDTO.setMenuItem(...);
            return itemDTO;
        }).collect(Collectors.toList());
        orderDTO.setOrderItems(orderItemDTOs);

        return orderDTO;
    }
}