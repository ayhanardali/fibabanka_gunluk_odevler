package com.example.fibabootcampproject2.service;

import com.example.fibabootcampproject2.Customer;

import java.util.List;

public interface CustomerService {


    void createCustomer(Customer customer);

    Customer read(long customerId);

    void updateCustomer(Customer customer);

    void deleteCustomer(long customerId);

    List<Customer> findAll();
}
