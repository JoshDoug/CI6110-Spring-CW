package com.ci6110.main;

import com.ci6110.beans.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InputController {

    @GetMapping("/employeeForm")
    public String employeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employeeForm";
    }

    @PostMapping("/employeeForm")
    public String employeeSubmit(@ModelAttribute Employee employee) {
        return "employeeSubmit";
    }
}