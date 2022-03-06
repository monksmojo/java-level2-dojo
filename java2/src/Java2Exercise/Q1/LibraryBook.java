package Java2Exercise.Q1;
import java.util.Scanner;

public class LibraryBook {
    String bookName;
    String bookAuthor;
    String publisher;
    LibraryMember lm;

    // static variables


    LibraryBook(String bn,String pb,String ba){
        this.bookName=bn;
        this.publisher=pb;
        this.bookAuthor=ba;
        this.lm=null;

    }

    @Override
    public String toString() {
        if(this.lm!=null){
            return String.format("bookName='" + bookName + ", bookAuthor='" + bookAuthor + ", publisher='" + publisher + ", Rented By->"+lm.memberName);
        }

        return String.format("bookName='" + bookName + ", bookAuthor='" + bookAuthor + ", publisher='" + publisher);

    }
}
