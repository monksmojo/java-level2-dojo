package com.practice.javawebservice;


import org.springframework.stereotype.Component;

@Component
public class BubbleSort implements Sort {

    @Override
    public void sortMethod() {
        System.out.println("bubble sort");
    }
}
