package com.example.inheritmap2.entity;

import javax.persistence.Entity;

@Entity
public class Yoga extends Training {
    private String centerLocation;
    private int hours;

    public String getCenterLocation() {
        return centerLocation;
    }

    public void setCenterLocation(String centerLocation) {
        this.centerLocation = centerLocation;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
