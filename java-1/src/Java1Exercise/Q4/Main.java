//Q4. Calculate the number & Percentage Of Lowercase Letters,Uppercase Letters,
// Digits And Other Special Characters In A String

package Java1Exercise.Q4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NullPointerException{
        System.out.println("execution of Q-4");
        Q4CharacterPercent obj=new Q4CharacterPercent();
        try{
            Scanner input=new Scanner(System.in);
            System.out.println("enter a string to count lower-case upper-case special-case");
            String phrase=input.nextLine();

            if(phrase.equals("")||phrase.equals(" ")){
                throw new NullPointerException();
            }

            obj.calculatePercent(phrase);
        }catch (NullPointerException nue){
            System.out.println("a null or blank string entered");
            System.out.println(nue);
        }
    }
}


class Q4CharacterPercent {


    void calculatePercent(String phrase){
        double lowerCount=0;
        double upperCount=0;
        double digitCount=0;
        double specialCount=0;
        double totalCount=phrase.length();
        double percent;
        char[] chArray=phrase.toCharArray();
        for (char ch:chArray) {
            if (Character.isUpperCase(ch)){
                upperCount+=1;
            }
            else if(Character.isLowerCase(ch)){
                lowerCount+=1;
            }
            else if(Character.isDigit(ch)){
                digitCount+=1;
            }
            else{
                specialCount+=1;
            }
        }//end of foreach loop
        System.out.println("digit percentage");
        System.out.println("total number of digits->"+digitCount);
        percent=(digitCount/totalCount)*100;
        System.out.println("digit %->"+percent);

        System.out.println("lowercase percentage");
        System.out.println("total number of lower case->"+lowerCount);
        percent=(lowerCount/totalCount)*100;
        System.out.println("lowercase %->"+percent);

        System.out.println("uppercase percentage");
        System.out.println("total number of uppercase->"+upperCount);
        percent=(upperCount/totalCount)*100;
        System.out.println("uppercase %->"+percent);

        System.out.println("specialcase percentage");
        System.out.println("total number of specialcase->"+specialCount);
        percent=(specialCount/totalCount)*100;
        System.out.println("specialcase %->"+percent);
    }// end of function
}//end of class

