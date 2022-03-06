package com.example.Q6SpringFramework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alpha {
    private Beta b;
    @Autowired
    Alpha(Beta obj){
        b=obj;
    }


    void callingBeta(){
        System.out.println("alpha calling beta");
        b.answerBeta();
    }
}
