//Q-5 Write a program to sort Employee objects based on highest salary using Comparator.
//Employee class{ Integer Age; Double Salary; String Name }
package CollectionsExercise.Q5;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("execution of Q5");

        ArrayList<Q5EmployeeData> empList=new ArrayList<Q5EmployeeData>();
        System.out.println("populating employeeData");
        empList.add(new Q5EmployeeData("paul",60000.0,25));
        empList.add(new Q5EmployeeData("drake",77000.0,21));
        empList.add(new Q5EmployeeData("josh",55000.0,18));
        empList.add(new Q5EmployeeData("jones",99000.0,24));
        empList.add(new Q5EmployeeData("cornor",80000.0,27));

        System.out.println("unsorted employees");
        SalaryComparator sc1=new SalaryComparator();
        sc1.traverseData(empList);

        System.out.println("sorting employee list");
        sc1.sortEmployee(empList);// question wants us to use comparator
        // instead of comparable

        System.out.println("sorted employees on basis of salary");
        sc1.traverseData(empList);
    }
}
class Q5EmployeeData {
    String name;
    Double salary;
    Integer age;
    Q5EmployeeData(String name,double salary,int age){
        this.name=name;
        this.salary=salary;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Q5EmployeeData{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

}// end of employee class

class SalaryComparator {

    public void sortEmployee(List<Q5EmployeeData> emplList){
        System.out.println("sorting employees");
        Collections.sort(emplList, new Comparator<Q5EmployeeData>() {
            @Override
            public int compare(Q5EmployeeData o1, Q5EmployeeData o2) {
                return -o1.salary.compareTo(o2.salary);
            }
        });
    }


    public void traverseData(@NotNull List<Q5EmployeeData> empList){
        for (Q5EmployeeData emp:empList) {
            System.out.println(emp);
        }
    }


}// end of comparator class
