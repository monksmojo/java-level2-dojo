package com.udemy.imtiazAhmad.pma.configuration;

import com.udemy.imtiazAhmad.pma.entity.Employee;
import com.udemy.imtiazAhmad.pma.entity.Project;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Project getProjectBean(){
        return new Project();
    }

    @Bean
    public Employee getEmployeeBean(){
        return new Employee();
    }
}
