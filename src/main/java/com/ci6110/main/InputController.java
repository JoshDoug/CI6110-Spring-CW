package com.ci6110.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InputController {

    @RequestMapping("submit") // Note: can use GetMapping to scope to just Get HTTP Requests
    public String employeeForm() {
        return "greeting";
    }

}
