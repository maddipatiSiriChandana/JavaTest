package com.example.demo;

import com.example.demo.Service.TaxService;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TaxService taxService;

    @PostMapping("/employees")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee employee) {
        // Save the employee details to the database
        employeeRepository.save(employee);

        return ResponseEntity.ok("Employee details saved successfully");
    }

    @GetMapping("/employees/tax")
    public List<TaxDetails> getTaxDetails() {
        List<TaxDetails> taxDetailsList = new ArrayList<>();
        List<Employee> employeeList = employeeRepository.findAll();

        for (Employee employee : employeeList) {
            TaxDetails taxDetails = taxService.calculateTax(employee);
            taxDetailsList.add(taxDetails);
        }

        return taxDetailsList;
    }
}