package com.example.fibabootcampproject2.resource;

import com.example.fibabootcampproject2.Customer;
import com.example.fibabootcampproject2.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerResource {

    private CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/api/customer/{id}")
    public Customer getCustomer(@PathVariable("id") long customerId)
    {
        return customerService.read(customerId);
    }

    @GetMapping("/api/customers")
    public List<Customer> getCustomers()
    {
        return customerService.findAll();
    }

    @PostMapping("/api/customer")
    public Customer postCustomer(@RequestBody Customer customer)
    {
        customer.setCustomerId(3);
        customerService.createCustomer(customer);
        return customer;
    }

    @PutMapping("/api/customer")
    public void putCustomer(@RequestBody Customer customer)
    {
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/api/customer/{id}")
    public void deleteCustomer(@PathVariable("id") long customerId)
    {
        customerService.deleteCustomer(customerId);
    }
}
