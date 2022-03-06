package com.example.inheritmap2.entity;

import javax.persistence.Entity;

@Entity
public class Gym extends Training {
    private String gymLocation;
    private int hours;

    public String getGymLocation() {
        return gymLocation;
    }

    public void setGymLocation(String gymLocation) {
        this.gymLocation = gymLocation;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
