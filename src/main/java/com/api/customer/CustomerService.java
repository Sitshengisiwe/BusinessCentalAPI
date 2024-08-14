package com.api.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public List<CustomerModel> findAll() {
        return repository.findAll();
    }

    public CustomerModel save(CustomerModel customer) {
        return repository.save(customer);
    }
}
