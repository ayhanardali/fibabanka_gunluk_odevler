package com.example.fibabootcampproject2.client;

import com.example.fibabootcampproject2.Customer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class CustomerController {

    @GetMapping("/customer/get")
    @ResponseBody
    public String getCustomer()
    {
        long customerId = 1;
        String url = "http://localhost:8080/api/customer/" + customerId;
        RestTemplate restTemplate = new RestTemplate();
        Customer customer = restTemplate.getForObject(url, Customer.class);
        System.out.println("Müşteri: " + customer.getCustomerName());
        return "Get başarılı: " + customer.getCustomerName() + " " + customer.getTotalDebit();
    }

    @GetMapping("/customer/post")
    @ResponseBody
    public String postCustomer()
    {
        Customer customer = new Customer(1, "Ayhan Ardalı", 1000);
        String url = "http://localhost:8080/api/customer/";
        RestTemplate restTemplate = new RestTemplate();
        Customer result = restTemplate.postForObject(url, customer, Customer.class);
        return "Post başarılı: " + result.getCustomerName() + " " + result.getTotalDebit();
    }

    @GetMapping("/customer/put")
    @ResponseBody
    public String putCustomer()
    {
        Customer customer = new Customer(2, "Bilal Çalar", 2000);
        String url = "http://localhost:8080/api/customer/";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<Customer>(customer), Void.class);
        return "Put başarılı.";
    }

    @GetMapping("/customer/delete")
    @ResponseBody
    public String deleteCustomer()
    {
        long customerId = 3;
        String url = "http://localhost:8080/api/customer/" + customerId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);
        return "Delete başarılı.";
    }
}
