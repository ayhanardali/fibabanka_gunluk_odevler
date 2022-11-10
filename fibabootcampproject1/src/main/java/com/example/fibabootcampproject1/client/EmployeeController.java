package com.example.fibabootcampproject1.client;

import com.example.fibabootcampproject1.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class EmployeeController {

    @GetMapping("/employee/get")
    @ResponseBody
    public String getEmployee()
    {
        long employeeId = 2;
        String url = "http://localhost:8080/api/employee/" + employeeId;
        RestTemplate restTemplate = new RestTemplate();
        Employee employee = restTemplate.getForObject(url, Employee.class);
        System.out.println("Çalışan: " + employee.getEmployeeName());
        return "Get başarılı: " + employee.getEmployeeName() + " " + employee.getMonthlySalary();
    }

    @GetMapping("/employee/post")
    @ResponseBody
    public String postEmployee()
    {
        Employee employee = new Employee(1, "Ayhan Ardalı", 10000);
        String url = "http://localhost:8080/api/employee/";
        RestTemplate restTemplate = new RestTemplate();
        Employee result = restTemplate.postForObject(url, employee, Employee.class);
        return "Post başarılı: " + result.getEmployeeName() + " " + result.getMonthlySalary();
    }

    @GetMapping("/employee/put")
    @ResponseBody
    public String putEmployee()
    {
        Employee employee = new Employee(2, "Bilal Çalar", 20000);
        String url = "http://localhost:8080/api/employee/";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<Employee>(employee), Void.class);
        return "Put başarılı.";
    }

    @GetMapping("/employee/delete")
    @ResponseBody
    public String deleteEmployee()
    {
        long employeeId = 3;
        String url = "http://localhost:8080/api/employee/" + employeeId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);
        return "Delete başarılı.";
    }
}
