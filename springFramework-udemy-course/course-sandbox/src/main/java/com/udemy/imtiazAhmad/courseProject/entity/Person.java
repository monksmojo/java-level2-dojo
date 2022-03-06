package com.udemy.imtiazAhmad.courseProject.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class Person {
    private String fullName;
    private Integer age;
    private Boolean employed;
    private String gender;

    public Person() {
    }

    public Person(String fullName, Integer age, Boolean employed, String gender) {
        this.fullName = fullName;
        this.age = age;
        this.employed = employed;
        this.gender = gender;
    }
}
