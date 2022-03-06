package Java2Exercise.Q1;

import java.util.Scanner;

public class Q1Library {
    static int booksNumber=0;
    static LibraryBook[] books =new LibraryBook[20];

    public void addBook(){
        System.out.println("fill details to add book");
        Scanner input=new Scanner(System.in);
        System.out.println("Book Name");
        String bn=input.nextLine();
        System.out.println("Book publisher");
        String pb=input.nextLine();
        System.out.println("Book Author");
        String ba=input.nextLine();

        //creating book object
//        LibraryBook lbo=new LibraryBook();
        booksNumber+=1;
        books[booksNumber-1]=new LibraryBook(bn,pb,ba);
    }


    public void bookList(){
        if(booksNumber==0){
            System.out.println("no books are added in shelf");
        }
            for (int i=0; i<booksNumber; i++) {
                System.out.println(books[i]);
            }
    }

    public void rentBook(){
        Scanner input=new Scanner(System.in);
        System.out.println("enter book name you want to search");
        String bName=input.nextLine();
        System.out.println();
        for(int i=0; i<booksNumber; i++){
            if(bName.equalsIgnoreCase(books[i].bookName)){
                System.out.println("Book Available");
                System.out.println("enter you name");
                String mn=input.nextLine();
                System.out.println("enter your id");
                int id=input.nextInt();

                System.out.println("assigning you the book");
                books[i].lm=new LibraryMember(id,mn, books[i]);
                break;
            }// end of if

            else{
                System.out.println("book not available");
            }//end of else
        }// end of for
    }// end of rent book function


    public  void rentedBookList(){
        boolean noRent=true;
        for(int i=0; i<booksNumber; i++){
            if(books[i].lm!=null){
                noRent=false;
                System.out.println("bookName-> " + books[i].bookName);
                System.out.println("Rented by-> "+ books[i].lm.memberName);
            }
        }
        if(noRent){
            System.out.println("no book is rented");
        }
    }



}
