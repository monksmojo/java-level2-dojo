package com.example.Q3SpringFramework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringFrameworkApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext;
        applicationContext=SpringApplication.run(SpringFrameworkApplication.class, args);
        Driver d1=applicationContext.getBean(Driver.class);
        // will fetch the driver class bean
        // driver class bean contain dependency
        // auto-wire the dependency to CarClass
        d1.start();// output-driving the car
    }

}
