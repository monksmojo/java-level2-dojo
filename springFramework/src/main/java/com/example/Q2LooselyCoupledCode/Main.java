package com.example.Q2LooselyCoupledCode;



public class Main {
    public static void main(String[] args) {
        System.out.println("example of loosely coupled");
        Driver d1=new Driver(new BikeClass());// loosely coupled
        d1.start();         //new CarClass() // if want to drive car


        // so will only change new BikeClass() if want to drive bike
        // or will change to the new CarClass() if want to drive car
    }
}
