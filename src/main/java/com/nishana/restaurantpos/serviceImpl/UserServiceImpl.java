package com.nishana.restaurantpos.serviceImpl;

import com.nishana.restaurantpos.dto.UserDTO;
import com.nishana.restaurantpos.exception.ResourceNotFoundException;
import com.nishana.restaurantpos.mapper.UserMapper;
import com.nishana.restaurantpos.model.User;
import com.nishana.restaurantpos.repository.UserRepository;
import com.nishana.restaurantpos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        return userMapper.toDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        User user = userMapper.toEntity(userDTO);
        user.setUserId(existingUser.getUserId()); // ensure the ID remains the same
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        userRepository.delete(user);
    }
}