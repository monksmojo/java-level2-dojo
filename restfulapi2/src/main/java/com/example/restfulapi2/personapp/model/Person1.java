package com.example.restfulapi2.personapp.model;


import io.swagger.v3.oas.annotations.media.Schema;

// Person Version 2 more detailed version
@Schema(title = "person model-2",description = "we use this model for versioning")
public class Person1 {
    private Integer id;
    private String firstName;
    private String lastName;
    private String password;
    private int age;
    private String hobby;


    public Person1(Integer id, String firstName, String lastName, String password, int age, String hobby) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.age = age;
        this.hobby = hobby;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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


    @Override
    public String toString() {
        return "Person1{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
