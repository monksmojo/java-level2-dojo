package com.example.mapping.one2many.bidirectional;


import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
class MappingApplicationTests {
    @Autowired
    BiRepository biRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void createAuthor() {
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

    @Test
    public void createAuthor1() {
        Author author = new Author();
        author.setAuthorName("max webber");
        author.setAuthorAge(55);

        Book book1 = new Book();
        book1.setBookName("paul");
        author.addBook(book1);

        Book book2 = new Book();
        book2.setBookName("readt it once");
        author.addBook(book2);

        biRepository.save(author);
    }

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    public void testCaching(){
        org.hibernate.Session session =entityManager.unwrap(Session.class);
        Author author=biRepository.findById(1).get();// run the query from database
        biRepository.findById(1);// run the query from level 1 cache

        session.evict(author); // remove the object from cache

        biRepository.findById(1); // run the query from database
    }

}