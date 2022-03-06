package com.in28minutes.junitmockito.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class PrintServiceImpl {

    public void say(){
        System.out.println("say hello from data impl");
    }
}
