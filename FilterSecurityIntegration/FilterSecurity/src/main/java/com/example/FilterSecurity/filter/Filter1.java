package com.example.FilterSecurity.filter;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

public class Filter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("======= Filter1 initialized =======");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        System.out.println("Filter1 -> processing " + req.getRequestURI());

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("Filter1 -> Completed " + req.getRequestURI());
    }

    @Override
    public void destroy() {
        System.out.println("========== Filter1 destroyed ==========");
    }

}
