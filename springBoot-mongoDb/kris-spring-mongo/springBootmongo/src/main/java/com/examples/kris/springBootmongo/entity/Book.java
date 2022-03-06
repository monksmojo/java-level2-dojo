package com.examples.kris.springBootmongo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Book")
@Getter
@Setter
public class Book {

    @Field(name = "book_id")
    @Id
    private Long bookId;

    @Field(name = "book_name")
    private String bookName;

    private String author;

    public Book(Long bookId, String bookName, String author) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
    }

    @Override
    public String toString() {
        return "entity{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
