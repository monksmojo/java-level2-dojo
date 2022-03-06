package com.example.Q1TightlyCoupledCode;


public class Drive {
    public static void main(String[] args) {
        System.out.println("example of hard coupled");
        BikeClass bikeObj=new BikeClass();// tightly coupled
        bikeObj.drive();
        // so will have to create complete object of the class in order to ride bike
        CarClass carObj=new CarClass();
        carObj.drive();
        // so will have to create complete object of the class in order to ride bike

    }
}
