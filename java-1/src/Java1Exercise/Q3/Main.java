//Q3. Write a program to find the number of occurrences of a character in a string.
// without using loop?
package Java1Exercise.Q3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NullPointerException{
        System.out.println("Executing Q-3");
        try{

            Scanner input=new Scanner(System.in);
            System.out.println("enter the string you want to traverse");
            String phrs=input.nextLine().toLowerCase();
            if(phrs.equals("")||phrs.equals(" ")){
                throw new NullPointerException();
            }
            System.out.println("character you want to search");
            char chr=input.next().charAt(0);
            Q3CharacterSequence q3o= new Q3CharacterSequence(phrs,chr);

            int length=q3o.getLength(); // length require for running recursive function
            int r=q3o.characterOccurence(length); // call to recursive function
            System.out.println("occurance of->"+chr+" in "+phrs+" is->"+r);

        }catch (NullPointerException nue){
            System.out.println("a null or empty string or character passed");
            System.out.println(nue);
        }
    }
}

class Q3CharacterSequence {
    String phrase;
    char[] chArray; //character array to store string
    int chArrayLength; // array length
    char ch; // character which user want to find in array
    int count=0; // count of the c

    Q3CharacterSequence(String phrase, char ch){
        this.chArray=phrase.toCharArray();
        this.chArrayLength=chArray.length-1; // to store last index of char array
        this.ch=ch;
        this.count=0;
    }


    int getLength(){
        return this.chArrayLength;
    }

    //traversing string without loop and counting occurrence of character using recursion
    int characterOccurence(int length){
        if (length < 0){
            return count;
        }
        if (chArray[length]==ch){
            ++count;
        }
        return characterOccurence(length-1);
    }
}
