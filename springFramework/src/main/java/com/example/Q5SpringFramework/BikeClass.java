package com.example.Q5SpringFramework;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BikeClass implements Vehicle{
    @Override
    public void drive() {
        System.out.println("Driving the bike");
    }
}
