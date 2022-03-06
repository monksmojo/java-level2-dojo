package com.example.Q4SpringFramework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringFrameworkApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext;
        applicationContext=SpringApplication.run(SpringFrameworkApplication.class, args);
        Driver d1=applicationContext.getBean(Driver.class);
        d1.start();
        for(String name:applicationContext.getBeanDefinitionNames())
        {
            System.out.println(name); // name of all the beans present in the project
        }
    }

}
