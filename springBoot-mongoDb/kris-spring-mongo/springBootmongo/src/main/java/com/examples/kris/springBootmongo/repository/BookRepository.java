package com.examples.kris.springBootmongo.repository;

import com.examples.kris.springBootmongo.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book,Long> {

    @Query(value = "{book_name:?0}")
    Book findByBookName(String bookName);

    @Query(value = "{author:?0}")
    Book findByAuthor(String author);
}
