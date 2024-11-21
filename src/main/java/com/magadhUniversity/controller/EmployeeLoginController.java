package com.magadhUniversity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeLoginController {

    @GetMapping("/employee_login")
    public String showEmployeeLogin() {
        return "employee_login"; // Create employee_login.html in the templates directory
    }
}
