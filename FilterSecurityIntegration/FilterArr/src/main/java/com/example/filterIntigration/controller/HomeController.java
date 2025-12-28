package com.example.filterIntigration.controller;

import com.example.filterIntigration.model.User;
import com.example.filterIntigration.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        System.out.println("=== HOME PAGE accessed - No authentication needed ===");
        return "home";
    }

    @GetMapping("/login")
    public String loginPage(HttpSession session) {
        System.out.println("=== LOGIN PAGE accessed ===");

        // If already logged in, redirect to appropriate page
        if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if ("ADMIN".equals(user.getRole())) {
                return "redirect:/admin/dashboard";
            } else {
                return "redirect:/user/profile";
            }
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                       @RequestParam("password") String password,
                       HttpSession session,
                       Model model) {

        System.out.println("=== LOGIN ATTEMPT: " + username + " ===");

        User user = userService.authenticate(username, password);

        if (user != null) {
            // Create session and store user
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(30 * 60); // 30 minutes

            System.out.println("Login successful for: " + username + " [" + user.getRole() + "]");

            // Redirect based on role
            if ("ADMIN".equals(user.getRole())) {
                return "redirect:/admin/dashboard";
            } else {
                return "redirect:/user/profile";
            }
        }

        System.out.println("Login FAILED for: " + username);
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        System.out.println("=== LOGOUT ===");
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

    @GetMapping("/user/profile")
    public String userProfile(HttpSession session, Model model) {
        System.out.println("=== USER PROFILE accessed ===");
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "user-profile";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard(HttpSession session, Model model) {
        System.out.println("=== ADMIN DASHBOARD accessed ===");
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "admin-dashboard";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        System.out.println("=== ACCESS DENIED page shown ===");
        return "access-denied";
    }

}
