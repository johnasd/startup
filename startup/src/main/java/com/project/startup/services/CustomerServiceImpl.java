package com.project.startup.services;

import com.project.startup.domain.Customer;
import com.project.startup.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findByCustomerFirstNameContaining(String firstName) {
        return customerRepository.findByFirstNameContaining(firstName);
    }
}
