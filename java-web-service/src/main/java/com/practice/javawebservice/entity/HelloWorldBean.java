package com.practice.javawebservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
public class HelloWorldBean {
    private String msg;

    HelloWorldBean(){

    }

    public HelloWorldBean(String msg){
        this.msg=msg;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
