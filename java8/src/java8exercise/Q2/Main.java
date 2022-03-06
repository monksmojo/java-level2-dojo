//Create a functional interface whose method takes 2 integers and return one integer.
package java8exercise.Q2;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("taking two int and returning one");
        ReturnNumber rn=(num1,num2)->num1;
        int num1=10;
        int num2=20;
        System.out.println("taking "+num1+" and "+num2+" and returning->"+rn.returnOne(num1,num2));
    }
}
