package com.example.filterIntigration.filter.user;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;

public class UserFilter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("======= UserFilter1 initialized =======");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        System.out.println("UserFilter1 -> processing " + req.getRequestURI());

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("UserFilter1 -> Completed " + req.getRequestURI());
    }

    @Override
    public void destroy() {
        System.out.println("========== UserFilter1 destroyed ==========");
    }

}
