//What will be the  output on new Child(); ?
package Java2Exercise.Q12;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("executing of Question 12");
        System.out.println("output -0");
        Grandparent g1=new Child();
        System.out.println("output-1");
        Parent p1=new Child();
        System.out.println("output-2");
        Child c1=new Child();
    }
}
