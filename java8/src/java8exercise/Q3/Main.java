//Using (instance) Method reference create and apply add and subtract method
// and using (Static) Method reference create and apply multiplication method for the functional interface created.
package java8exercise.Q3;


public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("functional interface refering static method of multiplication");
        Universe uni1= Operations::multiplyme; // static method of Operations
        int result=uni1.global(10,30); // overriding static class
        System.out.println(result); // print result

        System.out.println("functional interface refering instance method of addition");
        Operations mobj1=new Operations(); // creating object of operation class
        Universe uni2=mobj1::addMe; // referring to the instance method
        result=uni2.global(10,30); // calling interface method
        System.out.println(result);

        System.out.println("functional interface refering instance method of subtraction");
        Operations mobj2=new Operations(); // creating object of operation class
        Universe uni3=mobj2::subtractMe; // referring to the instance method
        result=uni3.global(30,10);
        System.out.println(result);
    }

}
