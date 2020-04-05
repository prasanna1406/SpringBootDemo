package com.practice.demo.controller;

import com.practice.demo.model.Customer;
import com.practice.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<Collection<Customer>> getCustomers(){
        Collection<Customer> customerList = customerService.getCustomers();
        return ResponseEntity.ok().body(customerList);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer updatedCustomer = customerService.createCustomer(customer);
        return ResponseEntity.created(null).body(updatedCustomer);
    }
}
