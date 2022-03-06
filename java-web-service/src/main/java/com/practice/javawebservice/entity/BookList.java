package com.practice.javawebservice.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class BookList {
    private static List<Book> myBookList = new ArrayList<>();

    static {
        myBookList.add(new Book(1,"book 1","me","pdf"));
        myBookList.add(new Book(2,"book 2","myself","e-book"));
        myBookList.add(new Book(3,"book 3","i","hard-cover"));
    }

    public List<Book> getMyBookList() {
        return myBookList;
    }

    public Book getSpecificBook(int index){
        for (Book book:myBookList){
            if(book.getBookNo()==index){
                return book;
            }
        }
        return null;
    }

    public Book getBookByAuthor(String authorName){
        for (Book book: myBookList) {
            if(book.getBookAuthor().equals(authorName)){
                return book;
            };
        }
        return null;
    }

    // adding book using @PostMapping
    public Boolean addBook(Book book){
        if(book!=null){
            if(book.getBookNo()==0){
                book.setBookNo(myBookList.size()+1);
            }
            myBookList.add(book);
            return true;
        }
        else {
            return false;
        }
    }


    // deleting a book using @DeleteMapping
    public Boolean deleteBook(int bookNo){
        // using iterator cause iterator are thread safe
        Iterator<Book> bookIterator=myBookList.iterator();
        while (bookIterator.hasNext()){
            Book book=bookIterator.next();
            if(book.getBookNo()==bookNo){
                bookIterator.remove();
                return true;
            }
        }
        // using for loop
//        for (Book book:myBookList) {
//            if(book.getBookNo()==bookNo){
//                myBookList.remove(book);
//                return true;
//            }
//        }
        return false;
    }

    // updating the books
    public Boolean updateBook(Book bookToUpdate){
        for (Book book:myBookList){
            if(book.getBookNo()==bookToUpdate.getBookNo()) {
                if(bookToUpdate.getBookAuthor()!=null){
                    book.setBookAuthor(bookToUpdate.getBookAuthor());
                }

                if(bookToUpdate.getBookType()!=null){
                    book.setBookAuthor(bookToUpdate.getBookType());
                }

                if(bookToUpdate.getBookName()!=null){
                    book.setBookAuthor(bookToUpdate.getBookAuthor());
                }

                return true;
            }
        }

        return false;
    }



}
