package java8course.video14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDataBase {
    public static List<Student> getStudentList(){
        Student student1=new Student("adam",2,3,"male", Arrays.asList("cricket","basketBall"));
        Student student2=new Student("eve",2,3,"female", Arrays.asList("cricket","basketBall"));
        Student student3=new Student("clark",2,3,"male", Arrays.asList("cricket","basketBall"));
        Student student4=new Student("bruce",2,3,"male", Arrays.asList("cricket","basketBall"));

        List<Student> studentList=Arrays.asList(student1,student2,student3,student4);
        return studentList;
    }


}
