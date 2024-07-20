package com.nishana.restaurantpos.service;


import org.springframework.stereotype.Service;

import com.nishana.restaurantpos.dto.LoginForm;

@Service
public interface AdminService {
    //boolean validateAdmin(String username, String password);
    boolean validateAdmin(LoginForm loginForm);
}
