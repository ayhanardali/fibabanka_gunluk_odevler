package com.example.fibabootcampproject1.resource;


import com.example.fibabootcampproject1.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeResource {

    @GetMapping("/api/employee/{id}")
    public Employee getEmployee(@PathVariable("id") long employeeId)
    {
        Employee employee = new Employee(employeeId, "Ayhan Ardalı", 10000);
        return employee;
    }

    @GetMapping("/api/employees")
    public List<Employee> getEmployees()
    {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Ayhan Ardalı", 10000));
        employeeList.add(new Employee(2, "Bilal Çalar", 20000));
        employeeList.add(new Employee(3, "Selçuk Altınay", 30000));
        return employeeList;
    }

    @PostMapping("/api/employee")
    public Employee postEmployee(@RequestBody Employee employee)
    {
        employee.setEmployeeId(1);
        System.out.println("Çalışan eklendi: " + employee.getEmployeeId() + " " + employee.getEmployeeName() + " " + employee.getMonthlySalary());
        return employee;
    }

    @PutMapping("/api/employee")
    public void putEmployee(@RequestBody Employee employee)
    {
        System.out.println("Çalışan güncellendi: " + employee.getEmployeeId() + " " + employee.getEmployeeName() + " " + employee.getMonthlySalary());
    }

    @DeleteMapping("/api/employee/{id}")
    public void deleteEmployee(@PathVariable("id") long employeeId)
    {
        System.out.println("Çalışan silindi: " + employeeId);
    }
}
