package com.example.Q4SpringFramework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Driver {
    @Autowired
    private Vehicle vehicleObj;

    Driver(Vehicle obj) {
        vehicleObj = obj;
    }

    void start() {
        vehicleObj.drive();
    }
}
