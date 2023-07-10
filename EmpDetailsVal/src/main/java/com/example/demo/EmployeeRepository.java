package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.validation.Valid;

@Repository
	public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	    Employee findByEmployeeId(int employeeId);

	Employee save(@Valid Employee employee);

	List<Employee> findAll();
	}