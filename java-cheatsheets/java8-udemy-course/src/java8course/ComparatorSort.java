package java8course;


import java.util.*;
import java.util.Scanner;

class Student1{
    private int id;
    private String fname;
    private double cgpa;

    public Student1(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class ComparatorSort {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int testCases = Integer.parseInt(in.nextLine());

            List<Student1> studentList = new ArrayList<Student1>();
            while(testCases>0){
                int id = in.nextInt();
                String fname = in.next();
                double cgpa = in.nextDouble();

                Student1 st1 = new Student1(id, fname, cgpa);
                studentList.add(st1);

                testCases--;
            }

            Collections.sort(studentList, new Comparator<Student1>() {
                @Override
                public int compare(Student1 student1, Student1 t1) {
                    if(student1.getCgpa()== t1.getCgpa()){
                        if(student1.getFname().equals(t1.getFname())){
                            return student1.getId()-t1.getId();
                        }
                        else{
                            return student1.getFname().compareTo(t1.getFname());
                        }
                    }else{
                        if (t1.getCgpa()-student1.getCgpa()>0)
                            return  1;
                        else
                            return -1;
                    }
                }
            });

            for(Student1 st: studentList){
                System.out.println(st.getFname());
            }
    }
}
