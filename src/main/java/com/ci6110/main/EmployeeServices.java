package com.ci6110.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServices {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServices(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        this.employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    private List<Float> employeeSalaries(List<Employee> employeeList) {
        return employeeList.stream().map(Employee::getSalary).collect(Collectors.toList());
    }

    public String averageSalary(List<Float> salaries) {
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        return decimalFormat.format(salaries.stream().mapToDouble(Float::doubleValue).sum() / salaries.size());
    }

    public String averageSalary() {
        return averageSalary(employeeSalaries(getAllEmployees()));
    }

    public String maxSalary() {
        List<Float> salaries = employeeSalaries(getAllEmployees());
        Optional<Float> max = salaries.stream().reduce(Float::max);

        if(max.isPresent()) {
            return max.get().toString();
        } else {
            return "No max salaries";
        }
    }
}