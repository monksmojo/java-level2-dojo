//8. WAP to read words from the keyboard until the word done is entered. For each word except done, report whether its first character is equal   to  its last character. For the required loop, use a
//a)while statement
//b)do-while statement
package Java2Exercise.Q8;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NullPointerException{
	// write your code here
        try{
            System.out.println("executing of Question 8");
            System.out.println("enter word to check its first character equals last character");
            Scanner input=new Scanner(System.in);
            String word=input.nextLine().toLowerCase();
            if(word.equals("")||word.equals(" ")){
                throw new NullPointerException();
            }
            else{
                Q8Done obj= new Q8Done();
                obj.loop1(word);
                obj.loop2(word);
            }
        }catch (NullPointerException nue){
            System.out.println("null string passed");
            System.out.println(nue);
        }

    }
}
