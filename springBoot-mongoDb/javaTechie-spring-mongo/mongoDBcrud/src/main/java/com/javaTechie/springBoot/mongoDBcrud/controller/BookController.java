package com.javaTechie.springBoot.mongoDBcrud.controller;

import com.javaTechie.springBoot.mongoDBcrud.entity.Book;
import com.javaTechie.springBoot.mongoDBcrud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestController
@RequestMapping(path = "/Tbooks")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @PostMapping(path = "/add-book")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        bookRepository.save(book);
        return new ResponseEntity<>("book created with id->"+book.getId(), HttpStatus.CREATED);
    }

    @GetMapping(path="/get-all-books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> bookList=bookRepository.findAll();
        return new ResponseEntity<>(bookList,HttpStatus.OK);
    }

    @GetMapping(path ="/get-book/{bookId}")
    public ResponseEntity<Object> getBook(@PathVariable Integer bookId){
        Book book=bookRepository.findById(bookId).orElse(null);
        if(book==null){
            return new ResponseEntity<>("book not found with id->"+bookId,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @DeleteMapping(path = "/remove-book/{bookId}")
    public ResponseEntity<String> removeBook(@PathVariable Integer bookId){
        bookRepository.deleteById(bookId);
        return new ResponseEntity<>("book deleted with id->"+bookId,HttpStatus.OK);
    }

}
