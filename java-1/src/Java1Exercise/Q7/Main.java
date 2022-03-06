//Q7. Write a program to print your Firstname,LastName & age
// using static block,static method & static variable respectively
package Java1Exercise.Q7;

public class Main {

    public static void main(String[] args){
        System.out.println("Executing of Q-7");
        System.out.println("getting firstName through Static variable");
        System.out.println(Q7StaticKeyword.firstName);
        System.out.println("getting age through Static method");
        System.out.println(Q7StaticKeyword.getAge());
    }
}

class Q7StaticKeyword {
    static String firstName="Udit";
    static String lastName;
    static{
        System.out.println("getting lastName through Static block");
        lastName="makkar";
        System.out.println(lastName);
    }

    Q7StaticKeyword(){
        System.out.println("object created");
        System.out.println("constructor called");
    } // they will never be called cause no objet is created

    static int getAge(){
        System.out.println("static method is called");
        return 24;
    }
}
