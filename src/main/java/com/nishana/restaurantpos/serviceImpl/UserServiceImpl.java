package com.nishana.restaurantpos.serviceImpl;

import com.nishana.restaurantpos.model.User;
import com.nishana.restaurantpos.repository.UserRepository;
import com.nishana.restaurantpos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
