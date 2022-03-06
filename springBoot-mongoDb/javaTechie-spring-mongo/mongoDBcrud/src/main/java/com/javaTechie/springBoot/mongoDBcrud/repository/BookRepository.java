package com.javaTechie.springBoot.mongoDBcrud.repository;

import com.javaTechie.springBoot.mongoDBcrud.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,Integer> {

}
