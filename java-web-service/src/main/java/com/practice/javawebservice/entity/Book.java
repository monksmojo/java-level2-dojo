package com.practice.javawebservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Component
@Getter
@Setter
public class Book {
    private  int bookNo;
    @Size(min = 3,message = "book name should be greater that 3")
    private  String bookName;
    @Size(min = 3,message = "book author should be greater that 3")
    private String bookAuthor;

    @NotNull
    private String bookType;

    Book(){
        super();
    }

    Book(Book bookToCopy){
        this.bookNo=bookToCopy.bookNo;
        this.bookAuthor=bookToCopy.bookAuthor;
        this.bookType=bookToCopy.bookType;
    }

    Book(int bookNo,String bookName,String bookAuthor,String bookType){
        super();
        this.bookNo=bookNo;
        this.bookName=bookName;
        this.bookType=bookType;
        this.bookAuthor=bookAuthor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookType='" + bookType + '\'' +
                '}';
    }
}
