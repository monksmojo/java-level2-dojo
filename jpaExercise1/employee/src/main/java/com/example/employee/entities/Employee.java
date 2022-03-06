//
package com.example.employee.entities;

import javax.persistence.*;

@Entity // mapping entity to database table
@Table(name = "employee") // table name in db
public class Employee {
    @Id // annotation for primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)// telling that the id is auto incremented
    private int id;
    private String name;
    private int age;
    @Column(name = "location") // column name in the database is location
    private String loc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", loc='" + loc + '\'' +
                '}';
    }
}
