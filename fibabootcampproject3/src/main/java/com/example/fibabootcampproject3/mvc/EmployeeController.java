package com.example.fibabootcampproject3.mvc;

import com.example.fibabootcampproject3.entity.Employee;
import com.example.fibabootcampproject3.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/bank")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees/bydepartment")
    @ResponseBody
    public String listDepartmentEmployees()
    {
        long departmentId = 1;
        List<Employee> employees = employeeRepository.findAllByDepartmentId(departmentId);
        double totalSalary = 0;
        for (Employee employee : employees) {
            System.out.println(employee.getEmployeeId()
                    + " "
                    + employee.getEmployeeName()
                    + " "
                    + employee.getMonthlySalary());
            totalSalary += employee.getMonthlySalary();
        }
        double averageSalary = 0;
        if (employees.size() > 0)
            averageSalary = totalSalary / employees.size();
        return "Departmandaki çalışanların ortalama maaşı: " + averageSalary;
    }
}
