package com.practice.javawebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BinarySearchImpl {

    @Autowired
    Sort sortObject;

    BinarySearchImpl(Sort sortObject){
        this.sortObject=sortObject;
    }

    String binarySearch(int[] arr, int numberToSearch){

        sortObject.sortMethod();
        return "found";

    }
}
