import java8course.Video10;
import java8course.Video3;
import java8course.Video4;
import java8course.video14.Student;
import java8course.video14.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main {
    public static void main(String args[]){
        Video3 video3=new Video3();
        video3.declarativeApproach();
        video3.imperativeApproach();

        Video4 video4=new Video4();
        video4.declarativeApproach();
        video4.imperativeApproach();


        Thread video10Thread=new Thread(new Video10());
        video10Thread.start();

        // creating the object of class video10;
        Video10 video10=new Video10();

        // accessing the anonymous function assigned to variable lambda1
        new Thread(video10.lambda1).start();

        // accessing the anonymous function assigned to variable lambda2
        new Thread(video10.lambda2).start();

        //prior to java 8
        // accessing lambda thread in main class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread of main class prior to java 8 ");
            }
        }).start();

        //after java 8.1
        // accessing lambda thread in main class
        new Thread(()-> System.out.println("thread of main class in java 8")).start();


        // comparator video 11
        // prior to java 8.1
        Comparator<Integer> comparator=new Comparator<Integer>() {
            @Override
            public int compare(Integer t0, Integer t1) {
                return t0.compareTo(t1);
                //0->t0==t1;
                //1->t1>t2;
                //-1->t1<t2
            }
        };

        System.out.println("result of comparator is: "+comparator.compare(10,29));

        Comparator<Integer> comparatorLambda=(Integer a1,Integer a2)->a1.compareTo(a2);

        System.out.println("result of the comparatorLambda is: "+comparatorLambda.compare(11,1));

        Comparator<Integer> comparatorLambda1=(a1,a2)->a1.compareTo(a2);

        System.out.println("result of the comparatorLambda1 is: "+comparatorLambda1.compare(11,11));


        //consumer in java
        // accepts input and perform operation on that input
        Consumer<String> c1=(s)->{
            System.out.println(s.toUpperCase());
        };

        c1.accept("java8");

        // real world example of consumers
        // with consumerChain
        Consumer<Student> studentConsumer=(student)-> System.out.print(student.getName()+" ");
        Consumer<Student> studentConsumer1=(student)-> System.out.println(student.getGender());
        List<Student> studentList= StudentDataBase.getStudentList();
        studentList.forEach(studentConsumer.andThen(studentConsumer1));

        System.out.println("printing only female student");
        studentList.forEach((student ->{
            if(student.getGender().equals("female")){
                studentConsumer.andThen(studentConsumer1).accept(student);
            }
        } ));
        // bi consumer accept two arguments instead of one and perform operations on it

        BiConsumer<Integer,Integer> multiply=(a,b)->{
            if(a>0&&b>0){
                System.out.println(a+" * "+b+" = "+a*b);
            }
        };

        multiply.accept(10,20);



    }
}
