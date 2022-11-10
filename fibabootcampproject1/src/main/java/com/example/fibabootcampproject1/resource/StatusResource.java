package com.example.fibabootcampproject1.resource;

import com.example.fibabootcampproject1.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusResource {

    @GetMapping("/status/ok/{id}")
    public ResponseEntity<?> getOk(@PathVariable("id") long employeeId)
    {
        Employee employee = new Employee(employeeId, "Ayhan Ardalı", 10000);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/status/notfound/{id}")
    public ResponseEntity<?> getNotFound(@PathVariable("id") long employeeId)
    {
        if (employeeId == 0)
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Çalışan bulunamadı.");
        Employee employee = new Employee(employeeId, "Ayhan Ardalı", 10000);
        return ResponseEntity.ok(employee);
    }
}
