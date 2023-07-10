package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Employee {
	    @NotNull
	    private String employeeId;

	    @NotBlank
	    private String firstName;

	    @NotBlank
	    private String lastName;

	    @Email
	    @NotBlank
	    private String email;

	    @NotEmpty
	    private List<String> phoneNumbers;

	    @NotNull
	    private LocalDate doj;

	    @NotNull
	    private Double salaryPerMonth;
	    @NotNull
	    private BigDecimal salary;
	    
	    public void setEmployeeId(String employeeId) {
	        this.employeeId = employeeId;
	    }
	    public String getEmployeeId() {
	        return employeeId;
	    }
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	    public String getFirstName() {
	        return firstName;
	    }
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	    public String getLastName() {
	        return lastName;
	    }
	    public void setSalaryPerMonth(Double salaryPerMonth) {
	        this.salaryPerMonth = salaryPerMonth;
	    }
	    public Double getSalaryPerMonth() {
	        return salaryPerMonth;
	    }
	    public void setDoj(LocalDate doj) {
	        this.doj = doj;
	    }
	    public LocalDate getDoj() {
	        return doj;
	    }
	    public void setSalary(BigDecimal salary) {
	        this.salary = salary;
	    }
	    public BigDecimal getSalary() {
	        return salary;
	    }
}
