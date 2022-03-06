package com.example.Q2LooselyCoupledCode;

public class Driver {

    private Vehicle vehicleObj;

    Driver(Vehicle obj) {
        vehicleObj = obj;
    }

    void start() {
        vehicleObj.drive();
    }
}
