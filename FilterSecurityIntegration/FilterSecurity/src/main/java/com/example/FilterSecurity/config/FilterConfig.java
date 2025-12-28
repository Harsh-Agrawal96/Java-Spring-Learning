package com.example.FilterSecurity.config;

import com.example.FilterSecurity.filter.Filter1;
import com.example.FilterSecurity.filter.Filter2;
import com.example.FilterSecurity.filter.admin.AdminFilter1;
import com.example.FilterSecurity.filter.admin.AdminFilter2;
import com.example.FilterSecurity.filter.user.UserFilter1;
import com.example.FilterSecurity.filter.user.UserFilter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<Filter1> f1Filter() {
        FilterRegistrationBean<Filter1> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new Filter1());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1); // First filter
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<Filter2> f2Filter() {
        FilterRegistrationBean<Filter2> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new Filter2());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(2); // Second filter
        return registrationBean;
    }

    // ========== User-specific Filters (Apply to /user/*) ==========

    @Bean
    public FilterRegistrationBean<UserFilter1> userFilter1() {
        FilterRegistrationBean<UserFilter1> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new UserFilter1());
        registrationBean.addUrlPatterns("/user/*");
        registrationBean.setOrder(3); // Third filter (only for /user/*)
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<UserFilter2> userFilter2() {
        FilterRegistrationBean<UserFilter2> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new UserFilter2());
        registrationBean.addUrlPatterns("/user/*");
        registrationBean.setOrder(4); // Fourth filter (only for /user/*)
        return registrationBean;
    }

    // ========== Admin-specific Filters (Apply to /admin/*) ==========

    @Bean
    public FilterRegistrationBean<AdminFilter1> adminFilter1() {
        FilterRegistrationBean<AdminFilter1> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AdminFilter1());
        registrationBean.addUrlPatterns("/admin/*");
        registrationBean.setOrder(3); // Third filter (only for /admin/*)
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<AdminFilter2> adminFilter2() {
        FilterRegistrationBean<AdminFilter2> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AdminFilter2());
        registrationBean.addUrlPatterns("/admin/*");
        registrationBean.setOrder(4); // Fourth filter (only for /admin/*)
        return registrationBean;
    }

}
