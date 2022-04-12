
package com.tcd.distributedsystems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@Service
public class AccessingDataMongodbApplication {

    @Autowired
    private CustomerRepository repository;

    // public static void main(String[] args) {
    // SpringApplication.run(AccessingDataMongodbApplication.class, args);
    // }

    public void run() throws Exception {

        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer(1, "Alice", "Smith"));
        repository.save(new Customer(2, "Bob", "Smith"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Smith")) {
            System.out.println(customer);
        }

    }

}