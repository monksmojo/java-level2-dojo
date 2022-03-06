package com.example.exercise.q1to6.entity;

import javax.persistence.*;

@Entity
public class Subjects {
    @Id
    private int subId;
    private String subjectName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auId")
    private Author author;

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
