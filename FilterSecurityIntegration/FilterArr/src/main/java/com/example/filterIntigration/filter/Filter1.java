package com.example.filterIntigration.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.FilterChain;
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
