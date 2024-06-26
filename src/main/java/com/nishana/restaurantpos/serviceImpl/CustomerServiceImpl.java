package com.nishana.restaurantpos.serviceImpl;

import com.nishana.restaurantpos.model.Customer;
import com.nishana.restaurantpos.repository.CustomerRepository;
import com.nishana.restaurantpos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomer() {

        return customerRepository.findAll();
    }

    @Override
    public Customer addCustomer(Customer customer) {
      return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
