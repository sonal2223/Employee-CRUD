package com.example.gtt.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gtt.entity.Employee;
import com.example.gtt.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // CREATE Employee
    @Transactional
    public Employee addEmployee(Employee employee) {
        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new IllegalArgumentException("Email already exists!");
        }
        if (employee.getDailySalary() <= 0) {
            throw new IllegalArgumentException("Daily salary must be greater than 0!");
        }
        return employeeRepository.save(employee);
    }

    // READ all
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // READ by ID
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + id));
    }

    // UPDATE
    @Transactional
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = getEmployeeById(id);

        if (!existing.getEmail().equals(employee.getEmail()) &&
            employeeRepository.existsByEmail(employee.getEmail())) {
            throw new IllegalArgumentException("Email already exists!");
        }

        if (employee.getDailySalary() <= 0) {
            throw new IllegalArgumentException("Daily salary must be greater than 0!");
        }

        existing.setName(employee.getName());
        existing.setEmail(employee.getEmail());
        existing.setDailySalary(employee.getDailySalary());

        return employeeRepository.save(existing);
    }

    // DELETE
    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }
}
