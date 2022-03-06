package com.examples.kris.springBootmongo.service;

import com.examples.kris.springBootmongo.DTO.BookDTO;
import com.examples.kris.springBootmongo.entity.Book;
import com.examples.kris.springBootmongo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Collection<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long bookId){
        return bookRepository.findById(bookId).orElse(null);
    }

    public Book getBookByName(String bookName){
        return bookRepository.findByBookName(bookName);
    }

    public Book getBookByAuthor(String authorName){
        Book book= bookRepository.findByAuthor(authorName);
        return book;
    }

    public Boolean addBook(Book book){
        bookRepository.insert(book);
        return true;
    }

    public Boolean removeBook(Long bookId){
        Optional<Book> book=bookRepository.findById(bookId);
        book.ifPresent(b->bookRepository.delete(b));
        bookRepository.deleteById(bookId);
        return true;
    }


    public Optional<Book> updateBook(Long id, BookDTO bookDto) {
        Optional<Book> book=bookRepository.findById(id);
        book.ifPresent(b->b.setBookName(bookDto.getBookName()));
        book.ifPresent(b->b.setAuthor(bookDto.getAuthor()));
        book.ifPresent(b->bookRepository.save(b));
        return book;
    }
}
