package com.example.FilterSecurity.interceptor;

import com.example.FilterSecurity.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        System.out.println("=== AuthInterceptor triggered for: " + request.getRequestURI() + " ===");

        HttpSession session = request.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;

        // Check if user is logged in
        if (user == null) {
            System.out.println("No user in session - redirecting to login");
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }

        String uri = request.getRequestURI();

        // Check if admin trying to access admin routes
        if (uri.contains("/admin/")) {
            if (!"ADMIN".equals(user.getRole())) {
                System.out.println("User " + user.getUsername() + " tried to access admin area - DENIED");
                response.sendRedirect(request.getContextPath() + "/access-denied");
                return false;
            }
        }

        System.out.println("Access granted to: " + user.getUsername() + " [" + user.getRole() + "]");
        return true;
    }

}
