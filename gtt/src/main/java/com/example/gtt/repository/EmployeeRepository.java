package com.example.gtt.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gtt.entity.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByEmail(String email);

    Optional<Employee> findByEmail(String email);

}
