//package com.UserManagementSystem.UserManagementSystemSpringBoot;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.UserManagementSystem.UserManagementSystemSpringBoot.Filter.BackButtonPrevention;
//import com.UserManagementSystem.UserManagementSystemSpringBoot.Filter.CheckUserRole;
//
//@Configuration
//public class Congif {
//	    
//	    private  BackButtonPrevention myFilter;
//	    private  CheckUserRole myFilter1;
//	    @Autowired
//	    public void filterConfiguration(BackButtonPrevention myFilter) {
//	        this.myFilter = myFilter;
//	    }
//	    @Autowired
//	    public void filterConfiguration(CheckUserRole myFilter1) {
//	        this.myFilter1 = myFilter1;
//	    }
//	    @Bean
//	    public FilterRegistrationBean<BackButtonPrevention> someFilterRegistration() {
//
//	        FilterRegistrationBean<BackButtonPrevention> registration = new FilterRegistrationBean<BackButtonPrevention>();
//	        registration.setFilter(myFilter);
//	        registration.addUrlPatterns("/userDetails","/userDashBoard","/editServlet","/adminWork","/userData");
//	        return registration;
//	    }
//	    @Bean
//	    public FilterRegistrationBean<CheckUserRole> someFilterRegistration1() {
//
//	        FilterRegistrationBean<CheckUserRole> registration = new FilterRegistrationBean<CheckUserRole>();
//	        registration.setFilter(myFilter1);
//	        registration.addUrlPatterns("/adminDashBoard","/adminWork");
//	        return registration;
//	    }
//}
