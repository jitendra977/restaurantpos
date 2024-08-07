package com.nishana.restaurantpos.mapper;

import com.nishana.restaurantpos.dto.UserDTO;
import com.nishana.restaurantpos.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // Convert User entity to UserDTO
    public UserDTO toDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    // Convert UserDTO to User entity
    public User toEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}