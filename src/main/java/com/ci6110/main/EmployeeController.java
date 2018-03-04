package com.ci6110.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/employeeData")
    public String employeeData(Model model) {
        model.addAttribute("employees", this.employeeServices.getAllEmployees());
        return "employeeData";
    }
}