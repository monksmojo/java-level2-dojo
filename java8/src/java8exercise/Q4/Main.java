//Create an Employee Class with instance variables (String) name, (Integer)age, (String)city and get the instance of the Class using constructor reference
package java8exercise.Q4;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Employee e1; // objecct of employee class
        Print p1=Employee::new; // print pi is object of interface
        e1=p1.printEmployee("udit",26,"new delhi");
        System.out.println(e1);

    }
}
