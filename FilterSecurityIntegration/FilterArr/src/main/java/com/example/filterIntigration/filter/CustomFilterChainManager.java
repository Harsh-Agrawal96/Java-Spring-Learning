package com.example.filterIntigration.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.filterIntigration.filter.admin.AdminFilter1;
import com.example.filterIntigration.filter.admin.AdminFilter2;
import com.example.filterIntigration.filter.user.UserFilter1;
import com.example.filterIntigration.filter.user.UserFilter2;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomFilterChainManager implements Filter {

    @Autowired
    private Filter1 f1Filter;

    @Autowired
    private Filter2 f2Filter;

    @Autowired
    private UserFilter1 userFilter1;

    @Autowired
    private UserFilter2 userFilter2;

    @Autowired
    private AdminFilter1 adminFilter1;

    @Autowired
    private AdminFilter2 adminFilter2;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("========== CustomFilterChainManager initialized ==========");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();

        System.out.println("\n========== Request: " + uri + " ==========");

        // Determine filter order based on route
        List<Filter> filters = getFilterChainForUri(uri);

        // Create custom filter chain with specific order
        CustomFilterChain customChain = new CustomFilterChain(filters, chain);
        customChain.doFilter(request, response);
    }

    private List<Filter> getFilterChainForUri(String uri) {
        List<Filter> filters = new ArrayList<>();

        if (uri.startsWith("/user")) {
            // Order for /user/* → F2, UserFilter2, F1, UserFilter1
            System.out.println("Filter order: F2 → UserFilter2 → F1 → UserFilter1");
            filters.add(f2Filter);
            filters.add(userFilter2);
            filters.add(f1Filter);
            filters.add(userFilter1);

        } else if (uri.startsWith("/admin")) {
            // Order for /admin/* → F2, AdminFilter1, F1, AdminFilter2
            System.out.println("Filter order: F2 → AdminFilter1 → F1 → AdminFilter2");
            filters.add(f2Filter);
            filters.add(adminFilter1);
            filters.add(f1Filter);
            filters.add(adminFilter2);

        } else {
            // Order for / and other routes → F2, F1
            System.out.println("Filter order: F2 → F1");
            filters.add(f2Filter);
            filters.add(f1Filter);
        }

        return filters;
    }

    @Override
    public void destroy() {
        System.out.println("========== CustomFilterChainManager destroyed ==========");
    }

    // Inner class: Custom FilterChain implementation
    private static class CustomFilterChain implements FilterChain {
        private final List<Filter> filters;
        private final FilterChain originalChain;
        private int currentPosition = 0;

        public CustomFilterChain(List<Filter> filters, FilterChain originalChain) {
            this.filters = filters;
            this.originalChain = originalChain;
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response)
                throws IOException, ServletException {

            if (currentPosition < filters.size()) {
                // Call next filter in our custom chain
                Filter nextFilter = filters.get(currentPosition);
                currentPosition++;
                nextFilter.doFilter(request, response, this);
            } else {
                // All custom filters done, continue to original chain (DispatcherServlet)
                originalChain.doFilter(request, response);
            }
        }
    }

}
