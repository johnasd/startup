package com.project.startup.bootstrap;

import com.project.startup.domain.Customer;
import com.project.startup.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public BootstrapData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("loading data.....");

        Customer c1 = new Customer();
        c1.setFirstName("John");
        c1.setLastName("Bornasal");
        customerRepository.save(c1);

        Customer c2 = new Customer();
        c2.setFirstName("Patrick");
        c2.setLastName("Li");
        customerRepository.save(c2);

        Customer c3 = new Customer();
        c3.setFirstName("Lois");
        c3.setLastName("Lane");
        customerRepository.save(c3);



        System.out.println("Customers saved. : " + customerRepository.count());

    }
}
