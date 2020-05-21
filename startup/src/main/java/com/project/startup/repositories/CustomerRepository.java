package com.project.startup.repositories;

import com.project.startup.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByFirstNameContaining(String firstName);

}
