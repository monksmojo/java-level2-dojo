//Q2. Write a program to find the number of occurrences of the duplicate words in a string.
// print them ?
package Java1Exercise.Q2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NullPointerException{
        try{
            Scanner input=new Scanner(System.in);
            System.out.println("enter a string with duplicate words");
            String phrase=input.nextLine().toLowerCase();
            if(phrase.equals("")||phrase.equals(" ")){
                throw new  NullPointerException();
            }
            Q2DuplicateWords.countDuplicate(phrase);
        }catch (NullPointerException ne){
            System.out.println("a empty or null string entered");
            System.out.println(ne);
        }
    }
}

class Q2DuplicateWords {
    static void countDuplicate(String phrase) throws NullPointerException{
            System.out.println(phrase);
            System.out.println("converting phrase into an array of words");
            String[] words=phrase.split(" ");
            System.out.println();
            int count=0;
            for (int i=0; i<words.length; i++){
                count=1;
                for (int j=i+1; j<words.length; j++) {
                    if(words[i].equals(words[j])){
                        count=count+1;
                        words[j]="0";
                    }
                }//end of inner loop
                if (count>1 && words[i]!="0"){
                    System.out.println(words[i]+"->"+count);
                }
            }//end of outer loop
    }
}