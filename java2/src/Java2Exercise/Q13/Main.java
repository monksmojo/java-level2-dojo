//Q13. Create a custom exception that do not have any stack trace.
package Java2Exercise.Q13;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("executing of Question 13");
        try{
            System.out.println("enter the password to check length");
            Scanner input=new Scanner(System.in);
            String password=input.nextLine();
            Q13PaswordChecker p1=new Q13PaswordChecker(password);
            p1.checkLength();

        }catch (PasswordException pe){
            System.out.println(pe);
            pe.printStackTrace();
        }
    }
}
