package com.example.dao;

import com.example.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.Map;

public interface EmployeeDAO {
    void saveEmployee(Employee emp);

    Employee getOneEmployee(Integer id);

    void updateEmployee(Employee emp);

    Map<Integer, Employee> getAllEmployees();

    void deleteEmployee(Integer id);

    void saveAllEmployees(Map<Integer, Employee> map);
}
