package com.example.fibabootcampproject3.repository;

import com.example.fibabootcampproject3.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("select e from Employee e where e.department.departmentId = :departmentId")
    List<Employee> findAllByDepartmentId(@Param("departmentId") long departmentId);

}
