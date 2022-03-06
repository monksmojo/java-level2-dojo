// Override the default method of the interface.
package java8exercise.Q7;

public class Main implements Moon{

    public void defaultCall(){ // overriding interface default method
        System.out.println("calling from the main method");
    }

    public static void main(String[] args) {
        Main m1=new Main();
        m1.defaultCall();
    }

}
