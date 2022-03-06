package com.example.Q5SpringFramework;

import org.springframework.stereotype.Component;

@Component
public class CarClass implements Vehicle {
    @Override
    public void drive() {
        System.out.println("driving the car");
    }
}
