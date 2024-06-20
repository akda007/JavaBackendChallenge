package com.trevis.startup.javaproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.trevis.startup.javaproject.impl.DepartmentServiceMock;
import com.trevis.startup.javaproject.impl.ServiceServiceMock;
import com.trevis.startup.javaproject.impl.UserServiceMock;
import com.trevis.startup.javaproject.services.*;

@Configuration
public class DependenciesConfiguration {

    @Bean @Scope()
    AuthService authService() { 
        //NOT IMPLEMENTED
        return null;
    }

    @Bean @Scope()
    DepartmentService departmentService() {
        return new DepartmentServiceMock();
    }

    @Bean @Scope()
    PasswordService passwordService() {
        //NOT IMPLEMENTED
        return null;
    }

    @Bean @Scope()
    ServiceService serviceService() {
        return new ServiceServiceMock();
    }

    @Bean @Scope()
    UserService userService() {
        return new UserServiceMock();
    }
}