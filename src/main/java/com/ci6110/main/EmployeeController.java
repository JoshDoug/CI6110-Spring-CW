package com.ci6110.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmployeeController {
    private EmployeeServices employeeServices;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeServices employeeServices) {
        super();
        this.employeeServices = employeeServices;
    }

    /**
     * Map View Form for entering Employee details
     * @param model
     * @return
     */
    @GetMapping("/employeeForm")
    public String employeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employeeForm";
    }

    /**
     * Handle submission of Employee details
     * @param employee
     * @return
     */
    @PostMapping("/employeeForm")
    public String employeeSubmit(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "employeeSubmit";
    }

    /**
     * Handle Employee deletion
     * @param model
     * @param employeeId
     * @return
     */
    @RequestMapping("/deleteEmployee/{employeeId}")
    public String deleteEmployee(Model model, @PathVariable(required = true, name = "employeeId") Long employeeId) {
        employeeRepository.deleteById(employeeId);
        model.addAttribute("employees", this.employeeServices.getAllEmployees());
        model.addAttribute("averageSalary", this.employeeServices.averageSalary());
        return "employeeData";
    }

    /**
     * Setup form containing Employee details ready to be edited
     * @param model
     * @param employeeId
     * @return
     */
    @GetMapping("/employeeUpdate/{employeeId}")
    public String editEmployee(Model model, @PathVariable(required = true, name = "employeeId") Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        model.addAttribute("employee", employee);
        return "employeeUpdate";
    }

    /**
     * Update employee details based on edits
     * @param employeeEdit
     * @return
     */
    @PostMapping("/employeeUpdate")
    public String submitEdit(@ModelAttribute Employee employeeEdit) {
        Optional<Employee> employee = employeeRepository.findById(employeeEdit.getEmployeeId());
        employeeRepository.save(employeeEdit);
        return "employeeSubmit";
    }

    /**
     * Return View containing list of Employees and their details, and additional metrics about their salaries
     * @param model
     * @return
     */
    @RequestMapping("/employeeData")
    public String employeeData(Model model) {
        model.addAttribute("employees", this.employeeServices.getAllEmployees());
        model.addAttribute("averageSalary", this.employeeServices.averageSalary());
        model.addAttribute("maxSalary", this.employeeServices.maxSalary());
        return "employeeData";
    }
}