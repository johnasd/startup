package com.project.startup.services;

import com.project.startup.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Optional<Customer> findCustomerById(Long Id);

    List<Customer> findAllCustomers();

    List<Customer> findByCustomerFirstNameContaining(String firstName);



}
