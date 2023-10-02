package com.example.dao;

import com.example.model.Employee;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final String hashReference = "Employee";

    @Resource(name = "redisTemplate")
    private HashOperations<String, Integer, Employee> hashOps;

    @Override
    public void saveEmployee(Employee emp) {
        hashOps.putIfAbsent(hashReference, emp.getId(), emp);

    }

    @Override
    public Employee getOneEmployee(Integer id) {
        return hashOps.get(hashReference, id);
    }

    @Override
    public void updateEmployee(Employee emp) {
        hashOps.put(hashReference, emp.getId(), emp);

    }

    @Override
    public Map<Integer, Employee> getAllEmployees() {
        return hashOps.entries(hashReference);
    }

    @Override
    public void deleteEmployee(Integer id) {

    }

    @Override
    public void saveAllEmployees(Map<Integer, Employee> map) {
        hashOps.putAll(hashReference, map);

    }
}
