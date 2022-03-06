//4. WAP to create singleton class.
package Java2Exercise.Q4;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("executing Question 4");
        Q4Singleton firstChild=Q4Singleton.makeChild();
        System.out.println(firstChild.childCreated);
        Q4Singleton secondChild=Q4Singleton.makeChild();
        System.out.println(secondChild.childCreated);
        Q4Singleton thirdChild=Q4Singleton.makeChild();
        System.out.println(thirdChild.childCreated);

    }
}
