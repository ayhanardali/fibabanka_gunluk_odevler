package com.example.fibabootcampproject2.resource;

import com.example.fibabootcampproject2.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusResource {

    @GetMapping("/status/ok/{id}")
    public ResponseEntity<?> getOk(@PathVariable("id") long customerId)
    {
        Customer customer = new Customer(customerId, "Ayhan Ardalı", 1000);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/status/notfound/{id}")
    public ResponseEntity<?> getNotFound(@PathVariable("id") long customerId)
    {
        if (customerId == 0)
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Çalışan bulunamadı.");
        Customer customer = new Customer(customerId, "Ayhan Ardalı", 1000);
        return ResponseEntity.ok(customer);
    }
}
