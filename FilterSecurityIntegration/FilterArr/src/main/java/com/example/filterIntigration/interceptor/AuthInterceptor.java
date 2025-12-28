package com.example.filterIntigration.interceptor;

import com.example.filterIntigration.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler) throws Exception {

        System.out.println("        AuthInterceptor → Checking: " + request.getRequestURI());

        HttpSession session = request.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;

        if (user == null) {
            System.out.println("        AuthInterceptor → No user - REDIRECT to /login");
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }

        String uri = request.getRequestURI();

        if (uri.contains("/admin/")) {
            if (!"ADMIN".equals(user.getRole())) {
                System.out.println("        AuthInterceptor → Access DENIED - not admin");
                response.sendRedirect(request.getContextPath() + "/access-denied");
                return false;
            }
        }

        System.out.println("        AuthInterceptor → Access GRANTED to " + user.getUsername());
        return true;
    }

}
