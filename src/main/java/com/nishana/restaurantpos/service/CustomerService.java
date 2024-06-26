package com.nishana.restaurantpos.service;


import com.nishana.restaurantpos.model.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomer();

    public Customer addCustomer(Customer customer);

    public  void deleteCustomer(Long id);
}
