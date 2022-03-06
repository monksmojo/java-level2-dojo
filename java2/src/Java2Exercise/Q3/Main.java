//3. WAP to produce NoClassDefFoundError and ClassNotFoundException exception.
package Java2Exercise.Q3;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("execution of question 3");
        Q3ClassException obj=new Q3ClassException();
        obj.notFound();
    }
}
