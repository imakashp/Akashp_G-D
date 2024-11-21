package com.magadhUniversity.controller;

import com.magadhUniversity.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @Autowired
    private NotificationService notificationService;

    /**
     * Displays the Home Page.
     * Shows login options for Admin, Employee, and Student, along with notifications.
     */
    @GetMapping("/")
    public String showHomePage(Model model) {
        // Fetch notifications to display on the home page
        model.addAttribute("notifications", notificationService.getAllNotifications());
        return "home"; // Refers to home.html
    }

    /**
     * Redirects to the Admin Login page.
     */
    @GetMapping("/admin-login")
    public String redirectToAdminLogin() {
        return "redirect:/login"; // Redirect to the admin login page
    }

    /**
     * Redirects to the Employee Login page.
     */
    @GetMapping("/employee-login")
    public String redirectToEmployeeLogin() {
        return "redirect:/employee-login"; // Redirect to the employee login page
    }

    /**
     * Redirects to the Student Login page.
     */
    @GetMapping("/student-login")
    public String redirectToStudentLogin() {
        return "redirect:/student-login"; // Redirect to the student login page
    }
}
