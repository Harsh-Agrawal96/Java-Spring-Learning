package com.example.FilterSecurity.filter.admin;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

public class AdminFilter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("======= AdminFilter1 initialized =======");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        System.out.println("AdminFilter1 -> processing " + req.getRequestURI());

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("AdminFilter1 -> Completed " + req.getRequestURI());
    }

    @Override
    public void destroy() {
        System.out.println("========== AdminFilter1 destroyed ==========");
    }

}
