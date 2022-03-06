package com.example.restfulapi2.personapp.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

//@JsonFilter("hobbyFilter") // to apply dynamic filtering uncomment this

// Person Version 1

@Schema(title = "person model-1",description = "contains properties of the person")
public class Person {
    private Integer id;
    private String name;

    @JsonIgnore // static filtering
    private String password;

    private int age;
    private String hobby;


    public Person(){

    }

    public Person(Integer id, String password,String name, int age, String hobby){
        this.id=id;
        this.name=name;
        this.age=age;
        this.hobby=hobby;
        this.password=password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
