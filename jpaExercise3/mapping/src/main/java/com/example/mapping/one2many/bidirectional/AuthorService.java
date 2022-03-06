package com.example.mapping.one2many.bidirectional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    BiRepository biRepository;

    public void createAuthor(){

        Author author = new Author();
        author.setAuthorName("regina");
        author.setAuthorAge(34);

        Book book1 = new Book();
        book1.setBookName("ikigai");
        author.addBook(book1);

        Book book2 = new Book();
        book2.setBookName("ying-yang");
        author.addBook(book2);
        biRepository.save(author);
    }
}
