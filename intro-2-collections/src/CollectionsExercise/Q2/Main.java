/* Q-2
Write a method that takes a string.
and returns the number of unique characters in the string.
*/
package CollectionsExercise.Q2;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
	// write your code here
        System.out.println("execution of Question-2");
        try{
            System.out.println("enter a string to check unique character");
            Scanner input=new Scanner(System.in);
            String phrase=input.nextLine().toLowerCase();
            Q2UniqueCharacters obj=new Q2UniqueCharacters();
            obj.uniqueCharacters(phrase);

        }catch (NullPointerException nue){
            System.out.println("pls enter a non-empty string");
            System.out.println(nue);
        }

    }
} // end of mainclass

class Q2UniqueCharacters {
    static Set<Character> character_set=new LinkedHashSet<Character>();
    private String phrase;

    //function
    void uniqueCharacters(@NotNull String phrase)throws NullPointerException{
        this.phrase = phrase;

        if(phrase.equals(null)||phrase.equals("")||phrase.equals(" ")){
            throw new NullPointerException();
        }

        else {
            for(int i=0; i<phrase.length(); i++){
                character_set.add(phrase.charAt(i));
            } // end of loop

            System.out.println("unique character in set-->"+character_set);

            System.out.println("number of unique characters-->"+character_set.size());

        }// end of else

    } // end of function

}