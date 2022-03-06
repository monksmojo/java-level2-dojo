package com.example.mapping.many2many;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aId;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "author_age")
    private int authorAge;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "author_booklist",
            joinColumns = @JoinColumn(name = "a_id",referencedColumnName = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "b_id",referencedColumnName = "book_id"))
    private List<Book> bookList;

    public Author() {
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

    public void addBook(Book book){
        if(bookList==null){
            bookList=new ArrayList<>();
        }
        bookList.add(book);
        book.getAuthors().add(this);
    }
}
