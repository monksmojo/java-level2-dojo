/*Q-3
Write a method that takes a string and
print the number of occurrence of each character characters in the string.
*/
package CollectionsExercise.Q3;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try{
            System.out.println("execution of Question 3");
            System.out.println("Enter a String");

            Scanner input=new Scanner(System.in);
            String phrase=input.nextLine().toLowerCase();

            Q3frequency obj1=new Q3frequency();
            obj1.countFrequency(phrase);

        }catch (NullPointerException nue){

            System.out.println("pls enter a not null string");
            System.out.println(nue);
        }
    }
}

class Q3frequency {
    Map<Character,Integer> frequency_map =new LinkedHashMap<Character, Integer>();

    void countFrequency(@NotNull String phrase) throws NullPointerException{
        if(phrase.equals(" ")||phrase.equals(null)||phrase.equals("")){
            throw new NullPointerException();
        }
        else{

            char[] phraseCharacter=phrase.toCharArray();
            for (int i=0; i<phraseCharacter.length; i++){
                if(frequency_map.containsKey(phraseCharacter[i])){
                    frequency_map.put(phraseCharacter[i], frequency_map.get(phraseCharacter[i])+1);
                }

                else{
                    frequency_map.put(phraseCharacter[i],1);
                }//end of inner else
            }// end of for loop
        }// end of outer else

        System.out.println(frequency_map);
    }// end of function

}//end of class


