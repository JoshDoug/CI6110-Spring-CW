package com.ci6110.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class EmployeeController {
    private EmployeeServices employeeServices;

    @Autowired
    public EmployeeController(EmployeeServices employeeServices) {
        super();
        this.employeeServices = employeeServices;
    }

    @GetMapping("/employeeForm")
    public String employeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employeeForm";
    }

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/employeeForm")
    public String employeeSubmit(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "employeeSubmit";
    }

    @RequestMapping("/deleteEmployee/{employeeId}")
    public String deleteEmployee(Model model, @PathVariable(required = true, name = "employeeId") Long employeeId) {
        employeeRepository.deleteById(employeeId);

        List<Employee> employeeList = this.employeeServices.getAllEmployees();
        String avgSalary = averageSalary(employeeSalaries(employeeList));

        model.addAttribute("employees", employeeList);
        model.addAttribute("averageSalary", avgSalary);

        return "employeeData";
    }

    @GetMapping("/employeeUpdate/{employeeId}")
    public String editEmployee(Model model, @PathVariable(required = true, name = "employeeId") Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        model.addAttribute("employee", employee);
        return "employeeUpdate";
    }

    @PostMapping("/employeeUpdate")
    public String submitEdit(@ModelAttribute Employee employeeEdit) {
        Optional<Employee> employee = employeeRepository.findById(employeeEdit.getEmployeeId());
        employeeRepository.save(employeeEdit);
        return "employeeSubmit";
    }

    @RequestMapping("/employeeData")
    public String employeeData(Model model) {
        List<Employee> employeeList = this.employeeServices.getAllEmployees();
        String avgSalary = averageSalary(employeeSalaries(employeeList));

        model.addAttribute("employees", employeeList);
        model.addAttribute("averageSalary", avgSalary);

        return "employeeData";
    }

    public List<Float> employeeSalaries(List<Employee> employeeList) {
        return employeeList.stream().map(Employee::getSalary).collect(Collectors.toList());
    }

    public String averageSalary(List<Float> salaries) {
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        return decimalFormat.format(salaries.stream().mapToDouble(Float::doubleValue).sum() / salaries.size());
    }
}