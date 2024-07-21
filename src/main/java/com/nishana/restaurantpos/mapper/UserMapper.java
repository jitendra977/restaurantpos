package com.nishana.restaurantpos.mapper;


import com.nishana.restaurantpos.dto.UserDTO;
import com.nishana.restaurantpos.model.User;

public class UserMapper {

    // Convert User entity to UserDTO
    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setName(user.getName());
        userDTO.setContactNumber(user.getContactNumber());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    // Convert UserDTO to User entity
    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setContactNumber(userDTO.getContactNumber());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}