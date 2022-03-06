package com.bootcampassignment.RestfulWebService.Q2.entity;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Employee {

    private Integer id;

    @Range(min = 18, message = "minimum age should be 18")
    private int age;

    @Size(min = 2, message = "name should be greater than 2 characters")
    private String name;

    Employee() {

    }

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
