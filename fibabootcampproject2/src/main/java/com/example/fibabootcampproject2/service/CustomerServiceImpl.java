package com.example.fibabootcampproject2.service;

import com.example.fibabootcampproject2.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Override
    public void createCustomer(Customer customer) {
        customer.setCustomerId(3);
        System.out.println("Müşteri eklendi: " + customer.getCustomerId() + " " + customer.getCustomerName() + " " + customer.getTotalDebit());
    }

    @Override
    public Customer read(long customerId) {
        System.out.println("Read başarılı");
        return new Customer(customerId, "Ayhan Ardalı", 1000);
    }

    @Override
    public void updateCustomer(Customer customer) {
        System.out.println("Müşteri güncellendi: " + customer.getCustomerId() + " " + customer.getCustomerName() + " " + customer.getTotalDebit());
    }

    @Override
    public void deleteCustomer(long customerId) {
        System.out.println("Müşteri silindi: " + customerId);
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Ayhan Ardalı", 1000));
        customerList.add(new Customer(2, "Bilal Çalar", 2000));
        customerList.add(new Customer(3, "Selçuk Altınay", 3000));
        return customerList;
    }
}
