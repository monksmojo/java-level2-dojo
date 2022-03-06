package com.example.mapping.many2many;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mapping.many2many.Author;
import java.util.*;

@Service
public class AuthorService {
    @Autowired
    ManyRepository manyRepository;

    public void insertAuthor(){

        Book b1=new Book();
        b1.setBookName("alpha");
        Book b2=new Book();
        b2.setBookName("beta");
        Book b3=new Book();
        b3.setBookName("omega");

        Author author=new Author();
        author.setAuthorName("hoax");
        author.setAuthorAge(23);
        author.setBookList(Arrays.asList(b1,b3));

        Author author1=new Author();
        author1.setAuthorName("xavier");
        author1.setAuthorAge(23);
        author1.setBookList(Arrays.asList(b2,b3));
        manyRepository.saveAll(Arrays.asList(author,author1));

    }
}
