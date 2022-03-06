//Create and access default and static method of an interface.
package java8exercise.Q6;

public class Main{

    public static void main(String[] args) {
        // write your code here
        Earth e1=new Earth(); // creating object of default earth class

        Universal.staticGlobal(); // calling static method of universal interface

        e1.defaultGlobal(); // calling default method of universal interface

        e1.display();// calling display method of earth class

    }

}
