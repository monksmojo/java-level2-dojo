package com.in28minutes.junitmockito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintComponent {

    @Autowired
    PrintServiceImpl printData;

    public void executeService(){
        printData.say();
    }
}
