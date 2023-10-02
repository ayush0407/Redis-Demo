package com.example;

import com.example.dao.EmployeeDAO;
import com.example.dao.EmployeeDAOImpl;
import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;
import java.util.logging.Logger;

@SpringBootApplication
public class RedisApplication implements CommandLineRunner {

    @Autowired
    private EmployeeDAOImpl dao;

    Logger LOG = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        dao.saveEmployee(new Employee(1,"Aj","Analytics","10M"));
        dao.saveAllEmployees(Map.of(1, new Employee(2,"Ak","Human Resources","5M"),
                2, new Employee(3,"Ap","Analytics","10M")));
        LOG.info(dao.getAllEmployees().toString());



    }
}
