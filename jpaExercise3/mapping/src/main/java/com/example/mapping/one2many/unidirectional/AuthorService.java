package com.example.mapping.one2many.unidirectional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    UniRepository uniRepository;

    public void addAuthor(){
        List<Book> bookList= Arrays.asList(new Book("bam"),new Book("kabam"),
                new Book("sazam"));
        Author author=new Author("yani",56,bookList);
        uniRepository.save(author);

        List<Book> bookList1= Arrays.asList(new Book("teenage"),new Book("wasteland"),
                new Book("this is"));
        Author author1=new Author("baba o riley",76,bookList1);
        uniRepository.save(author1);
    }
}
