package com.example.demo;

import java.math.BigDecimal;

public class EmployeeTaxResponse {
	    private String employeeId;
	    private String firstName;
	    private String lastName;
	    private BigDecimal yearlySalary;
	    private BigDecimal taxAmount;
	    private BigDecimal cessAmount;
	    public void setYearlySalary(String lastName) {
	        this.lastName = lastName;
	    }
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
	    public void setYearlySalary(BigDecimal yearlySalary) {
	        this.yearlySalary = yearlySalary;
	    }
	    public BigDecimal getYearlySalary() {
	        return yearlySalary;
	    }
	    public void setTaxAmount(BigDecimal taxAmount) {
	        this.taxAmount = taxAmount;
	    }
	    public BigDecimal getTaxAmount() {
	        return taxAmount;
	    }
	    public void setCessAmount(BigDecimal cessAmount) {
	        this.cessAmount = cessAmount;
	    }
	    public BigDecimal getCessAmount() {
	        return cessAmount;
	    }
}
