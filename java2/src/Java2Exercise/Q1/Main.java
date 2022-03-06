//  Create Java classes having suitable attributes for Library management system.
//  Use OOPs concepts in your design.
//  Also try to use interfaces and abstract classes.

package Java2Exercise.Q1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Execution of Q1");
        Q1Library lib=new Q1Library();
        int option;
        do {
            System.out.println("welcome to the library");
            System.out.println("How may i help you");
            System.out.println("1. Add a Book");
            System.out.println("2. Rent a Book");
            System.out.println("3. Book List");
            System.out.println("4. Rented Books");
            System.out.println("5. exit");
            Scanner input=new Scanner(System.in);
            option=input.nextInt();
            switch (option){
                case 1:
                    System.out.println("Add A Book");
                    lib.addBook();
                    break;

                case 2:
                    System.out.println("Rent A Book");
                    lib.rentBook();
                    break;

                case 3:
                    System.out.println("See Book List");
                    lib.bookList();
                    break;

                case 4:
                    System.out.println("Books on rent are");
                    lib.rentedBookList();
                    break;

                case 5:
                    System.out.println("exit");

                default:
                    System.out.println("option not available");
            }

        }while (option!=5);
    }

}


