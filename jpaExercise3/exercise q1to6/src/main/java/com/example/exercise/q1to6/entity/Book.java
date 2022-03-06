package com.example.exercise.q1to6.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Book {
    @Id
    private int bId;
    private String BookName;
    private String PublisherName;

    @OneToOne
    @JoinColumn(name = "auId")
    Author author;

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getPublisherName() {
        return PublisherName;
    }

    public void setPublisherName(String publisherName) {
        PublisherName = publisherName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
