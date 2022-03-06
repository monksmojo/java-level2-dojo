package Java2Exercise.Q8;

import javax.print.attribute.standard.NumberUp;
import java.util.Scanner;

public class Q8Done {
    public void loop1(String word) throws NullPointerException{
        System.out.println("using while loop");
        while(!(word.equalsIgnoreCase("done"))){

            if(word.charAt(0)==word.charAt(word.length()-1)){
                System.out.println("1st Character & last character");
                System.out.println("are equal");
            }

            else{
                System.out.println("1st Character & last character");
                System.out.println("are not equal");
            }

            System.out.println("enter done to exit or other word to check character");
            Scanner input=new Scanner(System.in);
            word=input.nextLine();
            if(word.equals("")||word.equals(null)){
                throw new NullPointerException();
            }
        }//end of while loop
    }// end of loop 1 function


    public void loop2(String word){
        System.out.println("using do while loop");
        do {

            if(word.charAt(0)==word.charAt(word.length()-1)){
                System.out.println("1st Character & last character");
                System.out.println("are equal");
            }

            else{
                System.out.println("1st Character & last character");
                System.out.println("are not equal");
            }

            System.out.println("enter done to exit or other word to check character");
            Scanner input=new Scanner(System.in);
            word=input.nextLine();
            if(word.equals("")||word.equals(null)){
                throw new NullPointerException();
            }

        }while(!(word.equalsIgnoreCase("done")));//end of while loop
    }// end of loop 1 function
}//end of class Q8Done
