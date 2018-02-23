package com.ci6110.main;

import com.ci6110.beans.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InputController {

//    @RequestMapping("submit") // Note: can use GetMapping to scope to just Get HTTP Requests
//    public String employeeForm() {
//        return "greeting";
//    }

    @GetMapping("/employee")
    public String employeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee";
    }

    @PostMapping("/employee")
    public String employeeSubmit(@ModelAttribute Employee employee) {
        return "employeeSubmit";
    }
}
