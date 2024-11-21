package com.magadhUniversity.controller;

import com.magadhUniversity.model.User;
import com.magadhUniversity.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @GetMapping
    public String showLoginForm() {
        return "login"; // Refers to login.html
    }

    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = loginService.validateUser(username, password);
        if (user != null) {
            model.addAttribute("message", "Welcome, " + user.getUsername() + "!");
            return "redirect:/admin"; // Redirect to a dashboard or homepage
        } else {
            model.addAttribute("error", "Invalid username or password!");
            return "login"; // Redirect back to the login page
        }
    }
}
