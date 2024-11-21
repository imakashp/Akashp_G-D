package com.magadhUniversity.controller;

import com.magadhUniversity.model.Employee;
import com.magadhUniversity.model.Student;
import com.magadhUniversity.model.Notification;
import com.magadhUniversity.service.EmployeeService;
import com.magadhUniversity.service.StudentService;
import com.magadhUniversity.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminDashboardController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private NotificationService notificationService;

    /**
     * Displays the Admin Dashboard with an overview of employees, students, and a graph.
     */
    @GetMapping("/admin")
    public String showAdminDashboard(Model model) {
        // Fetch employees and students
        List<Employee> employees = employeeService.getAllEmployees();
        List<Student> students = studentService.getAllStudents();

        // Calculate totals
        int totalEmployees = employees.size();
        int totalStudents = students.size();

        // Pass data to the view
        model.addAttribute("employees", employees);
        model.addAttribute("students", students);
        model.addAttribute("totalEmployees", totalEmployees);
        model.addAttribute("totalStudents", totalStudents);

        return "admin_dashboard"; // Refers to admin_dashboard.html
    }

    /**
     * Displays the Notification Management page.
     */
    @GetMapping("/admin/notifications")
    public String showNotificationForm(Model model) {
        // Fetch existing notifications
        List<Notification> notifications = notificationService.getAllNotifications();
        model.addAttribute("notifications", notifications);

        return "admin_notifications"; // Refers to admin_notifications.html
    }

    /**
     * Handles adding new notifications.
     */
    @PostMapping("/admin/notifications")
    public String saveNotification(@RequestParam String title, @RequestParam String description) {
        // Create and save a new notification
        Notification notification = new Notification();
        notification.setTitle(title);
        notification.setDescription(description);
        notificationService.saveNotification(notification);

        return "redirect:/admin/notifications";
    }
}
