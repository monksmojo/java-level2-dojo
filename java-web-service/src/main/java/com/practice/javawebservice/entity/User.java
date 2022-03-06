package com.practice.javawebservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "User")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long UserId;

    private String name;

    private Integer age;

    private String location;

    @OneToMany(mappedBy = "user")
    private List<Posts> postsList;

    public User(){

    }

    public User(String name, Integer age, String location) {
        this.name = name;
        this.age = age;
        this.location = location;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", location='" + location + '\'' +
                '}';
    }
}
