package com.project.startup.controllers;

import com.project.startup.domain.Customer;
import com.project.startup.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "api/v1/customers";

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam( required = false) String firstName) {
        try {

            ResponseEntity<List<Customer>> responseEntity = null;
            List<Customer> customers = new ArrayList<>();

            if( firstName == null ) {
                customers = customerService.findAllCustomers();
                if (customers.isEmpty()) {
                    responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
                } else {
                    responseEntity = new ResponseEntity<>(customers, HttpStatus.OK);
                }
            } else {
                    customerService.findByCustomerFirstNameContaining(firstName).forEach(customers::add);
                    responseEntity = new ResponseEntity<>(customers, HttpStatus.OK);
            }

            return responseEntity;
        } catch( Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        ResponseEntity<Customer> responseEntity = null;
        Optional<Customer> _customer = customerService.findCustomerById(id);

        if ( _customer.isPresent() ) {
            responseEntity =  new ResponseEntity<>( _customer.get(), HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }
}
