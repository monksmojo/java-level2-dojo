package com.examples.kris.springBootmongo.controller;

import com.examples.kris.springBootmongo.DTO.BookDTO;
import com.examples.kris.springBootmongo.entity.Book;
import com.examples.kris.springBootmongo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/Kbook")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping(path = "/get-all-books")
    public ResponseEntity<Collection<Book>> getAllBooks(){
        Collection<Book> bookList=bookService.getAllBook();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping(path = "/get-book/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable Long bookId){
        Book book=bookService.getBookById(bookId);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @GetMapping(path = "/get-book-by-name/{bookName}")
    public ResponseEntity<Book> getBookByName(@PathVariable String bookName){
        Book book=bookService.getBookByName(bookName);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @GetMapping(path = "/get-book-by-author/{authorName}")
    public ResponseEntity<Book> getBookByAuthor(@PathVariable String authorName){
        Book book=bookService.getBookByAuthor(authorName);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @PostMapping(path = "/add-book")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        bookService.addBook(book);
        return new ResponseEntity("the book has been added",HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete-book/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId){
        bookService.removeBook(bookId);
        return new ResponseEntity<>("the book has been removed",HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/update-book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id,@RequestBody BookDTO bookDto){
        Book book=bookService.updateBook(id,bookDto).orElse(null);
        return new ResponseEntity<>(book,HttpStatus.CREATED);
    }

}
