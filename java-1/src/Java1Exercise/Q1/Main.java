//Q1. Write a program to replace a substring inside a string with other string ?

package Java1Exercise.Q1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Executing Q-1");
        Q1StringReplace q1o=new Q1StringReplace();

        try{
            q1o.replaceAll("all sad sad","sad","happy");

        }catch (NullPointerException ne){
            System.out.println("empty string are being passed in the arguments");
            System.out.println(ne);
        }

    }
}

class Q1StringReplace {


    void replaceAll(String phrase,String oldString,String newString) throws  NullPointerException{
        if(phrase.equals("") || oldString.equals("") || newString.equals("") )
        {
            throw new NullPointerException();

        }// end of if
        else{
            if(phrase.contains(oldString)){
                System.out.println("replacing each old substring with new substring");
                System.out.println(phrase);
                System.out.println("replacing->"+oldString+" with "+newString);
                System.out.println(phrase.replace(oldString,newString));
            }
            else{
                System.out.println("the substtring you want to replace dosen't exist");
            }

        }// end of outer else
    } // end of replaceAll function

}//end of class

