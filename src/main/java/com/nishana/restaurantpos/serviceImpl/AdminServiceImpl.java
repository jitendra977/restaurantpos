package com.nishana.restaurantpos.serviceImpl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.nishana.restaurantpos.dto.LoginForm;
import com.nishana.restaurantpos.model.Admin;
import com.nishana.restaurantpos.repository.AdminRepository;
import com.nishana.restaurantpos.service.AdminService;


@RequiredArgsConstructor // goi all Constructor
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Override
    public boolean validateAdmin(LoginForm loginForm) {
        Admin admin = adminRepository.findByUsername(loginForm.getUsername());
        return admin != null && admin.getPassword().equals(loginForm.getPassword());
    }
}
