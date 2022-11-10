package com.example.fibabootcampproject3.mvc;

import com.example.fibabootcampproject3.entity.Department;
import com.example.fibabootcampproject3.entity.Employee;
import com.example.fibabootcampproject3.repository.DepartmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/bank")
public class DepartmentController {

    private DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/department/insert")
    @ResponseBody
    public String insertDepartment()
    {
        Department departmentHR = new Department(0, "Human Resources");
        departmentHR.setEmployeeList(new ArrayList<>());

        Employee employee1 = new Employee(0, "Büşra Tekdemir", 10000);
        employee1.setDepartment(departmentHR);
        departmentHR.getEmployeeList().add(employee1);

        Employee employee2 = new Employee(0, "Anıl Yazıcıoğlu", 15000);
        employee2.setDepartment(departmentHR);
        departmentHR.getEmployeeList().add(employee2);

        Employee employee3 = new Employee(0, "Bilge Akın", 20000);
        employee3.setDepartment(departmentHR);
        departmentHR.getEmployeeList().add(employee3);

        departmentRepository.save(departmentHR);

        return "Eklendi: " + departmentHR.getDepartmentName();
    }
}
