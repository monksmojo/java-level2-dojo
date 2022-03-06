package com.example.exercise.q1to6.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int auId;
    private String authorName;
    private int authorAge;

    @OneToOne(mappedBy = "author",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Book book;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Subjects> subjectsList;

    public int getAuId() {
        return auId;
    }

    public void setAuId(int auId) {
        this.auId = auId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getAuthorAge() {
        return authorAge;
    }

    public void setAuthorAge(int authorAge) {
        this.authorAge = authorAge;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Subjects> getSubjectsList() {
        return subjectsList;
    }

    public void setSubjectsList(Set<Subjects> subjectsList) {
        this.subjectsList = subjectsList;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void addSubject(Subjects subject){
        if(subjectsList==null){
            subjectsList= new HashSet<>();
        }
        subject.setAuthor(this);
        subjectsList.add(subject);
    }

    public void addBook(Book book){
        this.setBook(book);
        book.setAuthor(this);
    }


}
