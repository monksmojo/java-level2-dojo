package com.example.inheritmap.entity;

import com.example.inheritmap.entity.Employee;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Trainee Employee")
public class TraineeEmployee extends Employee {
    private String assessment;

    public TraineeEmployee(){
        super();
    }
    public TraineeEmployee(int id, String firstName, String lastName, double salary, int age,String assessment) {
        super(id, firstName, lastName, salary, age);
        this.assessment = assessment;
    }

    public String getAssessment() {
        return assessment;
    }

}
