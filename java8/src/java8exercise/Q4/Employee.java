package java8exercise.Q4;

public class Employee {
    String name;
    int age;
    String city;

    Employee(String n,int age,String city){
        this.name=n;
        this.age=age;
        this.city=city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
