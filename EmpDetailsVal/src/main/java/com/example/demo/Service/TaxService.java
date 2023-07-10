package com.example.demo.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;


import com.example.demo.TaxDetails;
import com.example.demo.Employee;
import org.springframework.stereotype.Service;

@Service
public class TaxService {
	    public static final double CESS_THRESHOLD = 2500000.0;
	    public static final double CESS_RATE = 0.02;

	    public TaxDetails calculateTax(Employee employee) {
	        LocalDate currentDate = LocalDate.now();
	        int currentYear = currentDate.getYear();
	        LocalDate startOfYear = LocalDate.of(currentYear, Month.APRIL, 1);
	        LocalDate endOfYear = LocalDate.of(currentYear + 1, Month.MARCH, 31);

	        int monthsWorked = getMonthsWorked(employee, startOfYear, endOfYear);

	        double totalSalary = employee.getSalaryPerMonth() * monthsWorked;

	        double taxAmount = calculateTaxAmount(totalSalary);
	        double cessAmount = calculateCessAmount(totalSalary);
	        return new TaxDetails(employee.getEmployeeId(), employee.getFirstName(),
	                employee.getLastName(), totalSalary, taxAmount, cessAmount);
	    }

	    private int getMonthsWorked(Employee employee, LocalDate startOfYear, LocalDate endOfYear) {
	        LocalDate startDate = employee.getDoj().isBefore(startOfYear) ? startOfYear : employee.getDoj();
	        LocalDate endDate = employee.getDoj().isBefore(endOfYear) ? employee.getDoj().plusYears(1) : endOfYear;
	        return Period.between(startDate, endDate).getMonths();
	    }

	    private double calculateTaxAmount(double totalSalary) {
	        if (totalSalary <= 250000) {
	            return 0.0;
	        } else if (totalSalary <= 500000) {
	            return (totalSalary - 250000)* 0.05;
	        } else if (totalSalary <= 1000000) {
	            return 12500 + (totalSalary - 500000) * 0.1;
	        } else {
	            return 112500 + (totalSalary - 1000000) * 0.2;
	        }
	    }

	    private double calculateCessAmount(double totalSalary) {
	        if (totalSalary > CESS_THRESHOLD) {
	            return (totalSalary - CESS_THRESHOLD) * CESS_RATE;
	        } else {
	            return 0.0;
	        }
	    }
	}