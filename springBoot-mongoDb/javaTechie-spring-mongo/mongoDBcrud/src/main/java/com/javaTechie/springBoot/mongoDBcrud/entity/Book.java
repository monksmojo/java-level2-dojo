package com.javaTechie.springBoot.mongoDBcrud.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter

@Document(collection = "Book")
public class Book {

    @Id
    private Integer id;
    private String bookName;
    private String authorName;
    private String type;
    private Integer numberOfPages;
    private Double price;

    public Book() {
    }

    public Book(Integer id, String bookName, String authorName, String type, Integer numberOfPages, Double price) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.type = type;
        this.numberOfPages = numberOfPages;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", type='" + type + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", price=" + price +
                '}';
    }
}
