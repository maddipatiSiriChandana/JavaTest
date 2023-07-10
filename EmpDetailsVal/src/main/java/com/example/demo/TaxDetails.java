package com.example.demo;

public class TaxDetails {
		public TaxDetails(Object employeeId2, Object firstName2, Object lastName2, double totalSalary, double taxAmount2,
			double cessAmount2) {
		// TODO Auto-generated constructor stub
	}
		private String employeeId;
	    private String firstName;
	    private String lastName;
	    private double yearlySalary;
	    private double taxAmount;
	    private double cessAmount;
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
	    public void setYearlySalary(Double yearlySalary) {
	        this.yearlySalary = yearlySalary;
	    }
	    public Double getYearlySalary() {
	        return yearlySalary;
	    }
	    public void setTaxAmount(Double taxAmount) {
	        this.taxAmount = taxAmount;
	    }
	    public Double getTaxAmount() {
	        return taxAmount;
	    }
	    public void setCessAmount(Double cessAmount) {
	        this.cessAmount = cessAmount;
	    }
	    public Double getCessAmount() {
	        return cessAmount;
	    }
	   
	}
