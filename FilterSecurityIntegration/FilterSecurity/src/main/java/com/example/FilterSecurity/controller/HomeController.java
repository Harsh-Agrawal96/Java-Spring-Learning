package com.example.FilterSecurity.controller;

import com.example.FilterSecurity.model.User;
import com.example.FilterSecurity.service.UserService;
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
        System.out.println("          CONTROLLER → Home page");
        return "home";
    }

    @GetMapping("/login")
    public String loginPage(HttpSession session) {
        System.out.println("          CONTROLLER → Login page");
        if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            return "ADMIN".equals(user.getRole()) ?
                "redirect:/admin/dashboard" : "redirect:/user/profile";
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                       @RequestParam String password,
                       HttpSession session, Model model) {
        System.out.println("          CONTROLLER → Login POST for: " + username);
        User user = userService.authenticate(username, password);

        if (user != null) {
            session.setAttribute("user", user);
            System.out.println("          Login successful: " + username + " [" + user.getRole() + "]");
            return "ADMIN".equals(user.getRole()) ?
                "redirect:/admin/dashboard" : "redirect:/user/profile";
        }

        System.out.println("          Login FAILED for: " + username);
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        System.out.println("          CONTROLLER → Logout");
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

    @GetMapping("/user/profile")
    public String userProfile(HttpSession session, Model model) {
        System.out.println("          CONTROLLER → User Profile");
        model.addAttribute("user", session.getAttribute("user"));
        return "user-profile";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard(HttpSession session, Model model) {
        System.out.println("          CONTROLLER → Admin Dashboard");
        model.addAttribute("user", session.getAttribute("user"));
        return "admin-dashboard";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        System.out.println("          CONTROLLER → Access Denied");
        return "access-denied";
    }

}
