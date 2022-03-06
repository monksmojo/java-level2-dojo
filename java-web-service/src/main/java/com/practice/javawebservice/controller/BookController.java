package com.practice.javawebservice.controller;

import com.practice.javawebservice.entity.Book;
import com.practice.javawebservice.entity.BookList;
import com.practice.javawebservice.entity.HelloWorldBean;
import com.practice.javawebservice.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    @Autowired
    BookList bookListObject;

    //simple @GetMapping to print string
    @GetMapping(path = "/hello-world")
    String getHelloWorld(){
        HelloWorldBean hb=new HelloWorldBean("hello string");
        return hb.getMsg();
    }

    // @GetMapping to print string with @PathVariable
    @GetMapping(path = "/hello-world-bean/{msg}")
    ResponseEntity<HelloWorldBean> getHelloWorldBean(@PathVariable String msg){
        return new ResponseEntity<>(new HelloWorldBean(msg),HttpStatus.OK);
    }

    // get all the books
    @GetMapping(path = "/")
    ResponseEntity<List<Book>> getBooks(){
        List<Book> bookList=bookListObject.getMyBookList();
        if(bookList==null){
            throw new NotFoundException("The Book List Is Empty");
        }
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    // get a specific book
    @GetMapping(path="/{bookNo}")
    EntityModel<Book> getSpecificBook(@PathVariable int bookNo){
        Book book=bookListObject.getSpecificBook(bookNo);
        if(book==null){
            throw new NotFoundException("no book found with id"+bookNo);
        }
//        return new ResponseEntity<>(book,HttpStatus.OK);
        // hateoas
        // returning link to another resource with the this uri response
        EntityModel<Book> resource = EntityModel.of(book);

        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).getBooks());

        resource.add(linkTo.withRel("all-books"));
        return  resource;

    }

    @GetMapping(path = "/search-by-author")
    ResponseEntity<Book> getBookByAuthor(@RequestParam String authorName){
        Book book=bookListObject.getBookByAuthor(authorName);
        if(book==null){
            throw new NotFoundException("book not found with author name"+authorName);
        }
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    // adding a book using @PostMapping
    @PostMapping(path ="/")
    ResponseEntity<String> addBookToTheList(@Valid @RequestBody Book book){
        if(bookListObject.addBook(book)){
            return new ResponseEntity<>("the book has been added",HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("the book can't be added",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        /**
         *
         * we can also return a uri which tells us
         * URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(book.getBookNo()).toUri();
         * return ResponseEntity.created(location).build();
         */
    }

    @DeleteMapping(path = "/remove-book/{bookNo}")
    ResponseEntity<String> removeBookFromList(@PathVariable int bookNo){
        if(bookListObject.deleteBook(bookNo)){
            return new ResponseEntity<>("The Book has been removed",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("the book with that book number found",HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/update-book")
    ResponseEntity<String> updateBookFromList(@RequestBody Book book){
        if(bookListObject.updateBook(book)) {
                return new ResponseEntity<>("the book has been updated", HttpStatus.OK);
        }
        else {
                return new ResponseEntity<>("the book cannot be updated",HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
