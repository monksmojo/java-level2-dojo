package com.example.Q4SpringFramework;

import org.springframework.stereotype.Component;

@Component
public class CarClass implements Vehicle{
    @Override
    public void drive() {
        System.out.println("Driving the Car");
    }
}
