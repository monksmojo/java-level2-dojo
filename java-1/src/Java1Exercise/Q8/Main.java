//Q8. Write a program to reverse a string and.
// remove character from index 4 to index 9
// from the reversed string using String Buffer
package Java1Exercise.Q8;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NullPointerException {
        System.out.println("execution of Q-8");
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("enter a string with at least 9 characters");
            String str = input.nextLine();

            if (str.equals("") || str.equals(" ") || str.length()<9) {
                throw new NullPointerException();
            }

            Q8ReverseString obj=new Q8ReverseString();
            obj.reverseMe(str);

        } catch (NullPointerException nue) {
            System.out.println("string enter null blank or character are less than 9");
            System.out.println(nue);
        }
    }

}

class Q8ReverseString {

    public void reverseMe(String str) {
        System.out.println("original string");
        StringBuffer sbr = new StringBuffer(str);
        System.out.println(sbr);
        System.out.println("reversed string");
        System.out.println(sbr.reverse());
        System.out.println("deleting the following characters");
        System.out.println(sbr.substring(4, 10));
        sbr.delete(4, 9);
        System.out.println("after deletion");
        System.out.println(sbr);
    }
}