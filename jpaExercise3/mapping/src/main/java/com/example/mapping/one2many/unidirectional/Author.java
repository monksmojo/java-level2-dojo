package com.example.mapping.one2many.unidirectional;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private int aId;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "author_age")
    private int authorAge;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinColumn(name = "a_id")
    private List<Book> bookList;

    public Author(){}

    public Author(String authorName, int authorAge, List<Book> bookList) {
        this.authorName = authorName;
        this.authorAge = authorAge;
        this.bookList = bookList;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
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

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
