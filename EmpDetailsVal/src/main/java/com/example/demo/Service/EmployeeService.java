package com.example.demo.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.EmployeeRepository;
import com.example.demo.EmployeeTaxResponse;

import com.example.demo.Employee;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<EmployeeTaxResponse> calculateTaxForCurrentFinancialYear() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeTaxResponse> employeeTaxResponses = new ArrayList<>();

        for (Employee employee : employees) {
            BigDecimal totalSalary = calculateSalaryForCurrentFinancialYear(employee);
            BigDecimal taxAmount = calculateTax(totalSalary);
            BigDecimal cessAmount = calculateCess(taxAmount);

            EmployeeTaxResponse employeeTaxResponse = new EmployeeTaxResponse();
            employeeTaxResponse.setEmployeeId(employee.getEmployeeId());
            employeeTaxResponse.setFirstName(employee.getFirstName());
            employeeTaxResponse.setLastName(employee.getLastName());
            employeeTaxResponse.setYearlySalary(totalSalary);
            employeeTaxResponse.setTaxAmount(taxAmount);
            employeeTaxResponse.setCessAmount(cessAmount);

            employeeTaxResponses.add(employeeTaxResponse);
        }

        return employeeTaxResponses;
    }

    private BigDecimal calculateSalaryForCurrentFinancialYear(Employee employee) {
        LocalDate doj = employee.getDoj();
        LocalDate currentFinancialYearStartDate = getFinancialYearStartDate(doj);

        BigDecimal totalSalary = BigDecimal.ZERO;
        for (int i = currentFinancialYearStartDate.getMonthValue(); i <= LocalDate.now().getMonthValue(); i++) {
            BigDecimal salaryForMonth = employee.getSalary().subtract(employee.getSalary().divide(new BigDecimal(30), RoundingMode.HALF_UP).multiply(new BigDecimal(getLossOfPayDaysPerMonth(employee))));
            totalSalary = totalSalary.add(salaryForMonth);
        }

        return totalSalary;
    }

    private LocalDate getFinancialYearStartDate(LocalDate doj) {
        LocalDate currentFinancialYearStartDate = LocalDate.of(doj.getYear(), Month.APRIL, 1);
        if (doj.isAfter(currentFinancialYearStartDate)) {
            currentFinancialYearStartDate = currentFinancialYearStartDate.plusYears(1);
        }
        return currentFinancialYearStartDate;
    }

    private BigDecimal calculateTax(BigDecimal yearlySalary) {
        BigDecimal taxAmount = BigDecimal.ZERO;

        if (yearlySalary.compareTo(new BigDecimal(250000)) > 0) {
            BigDecimal taxableAmount = yearlySalary.subtract(new BigDecimal(250000));
            if (taxableAmount.compareTo(new BigDecimal(250000)) <= 0) {
                taxAmount = taxableAmount.multiply(new BigDecimal(0.05));
            } else if (taxableAmount.compareTo(new BigDecimal(500000)) <= 0) {
                taxAmount = taxableAmount.subtract(new BigDecimal(250000)).multiply(new BigDecimal(0.1)).add(new BigDecimal(12500));
            } else if (taxableAmount.compareTo(new BigDecimal(1000000)) <= 0) {
                taxAmount = taxableAmount.subtract(new BigDecimal(500000)).multiply(new BigDecimal(0.2)).add(new BigDecimal(37500));
            } else {
                taxAmount = taxableAmount.subtract(new BigDecimal(1000000)).multiply(new BigDecimal(0.3)).add(new BigDecimal(137500));
            }
        }

        return taxAmount;
    }

    private BigDecimal calculateCess(BigDecimal taxAmount) {
        if (taxAmount.multiply(new BigDecimal(100)).compareTo(new BigDecimal(250000)) > 0) {
            return taxAmount.multiply(new BigDecimal(0.02));
        }
        return BigDecimal.ZERO;
    }

    private int getLossOfPayDaysPerMonth(Employee employee) {
        return employee.getSalary().divide(new BigDecimal(30), RoundingMode.HALF_UP).intValue();
    }


}
