package com.example.inheritmap.entity;

import com.example.inheritmap.entity.Employee;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Regular Employee")
public class RegularEmployee extends Employee {
    private String project;

    public RegularEmployee(){
        super();

    }

    public RegularEmployee(int id, String firstName, String lastName, double salary, int age,String project) {
        super(id, firstName, lastName, salary, age);
        this.project = project;
    }

    public String getProject() {
        return project;
    }


    @Override
    public String toString() {
        return "RegularEmployee{" +
                "id='" + this.getId() + '\'' +
                "name='" + this.getFirstName() +" "+this.getLastName()+ '\'' +
                "age='" + this.getAge() + '\'' +
                "salary='" + this.getSalary() + '\'' +
                "project='" + project + '\'' +
                '}';
    }
}
