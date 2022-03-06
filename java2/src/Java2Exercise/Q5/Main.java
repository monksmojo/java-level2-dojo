//5. WAP to show object cloning in java using cloneable and copy constructor both.
package Java2Exercise.Q5;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("executing Question 5");
        Q5ObjectCloning originalObject=new Q5ObjectCloning(12.1,"theory of x");
        System.out.println(originalObject);


        Q5ObjectCloning copyObject1=new Q5ObjectCloning(originalObject);
        System.out.println(copyObject1);


        try{
            Q5ObjectCloning originalObject1=new Q5ObjectCloning(101,"ikigai");
            System.out.println("calling clone function");
            Q5ObjectCloning copyObject2=(Q5ObjectCloning) originalObject1.clone();
            System.out.println(copyObject2);
        }catch(CloneNotSupportedException c){}
    }
}
