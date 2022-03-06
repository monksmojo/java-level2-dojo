// Q-6 Write a program to sort the Student objects based on Score ,
// if the score are same then sort on First Name .
//Class Student{ String Name; Double Score; Integer Age)

package CollectionsExercise.Q6;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {
//  write your code here

        System.out.println("execution of Q6");
        List<Q6StudentData> stdList=new ArrayList<Q6StudentData>();
        System.out.println("populating student data");
        stdList.add(new Q6StudentData("solee",98.7,15));
        stdList.add(new Q6StudentData("andrew",81.4,24));
        stdList.add(new Q6StudentData("clique",88.3,18));
        stdList.add(new Q6StudentData("bruce",68.2,16));
        stdList.add(new Q6StudentData("tony",81.4,17));

        System.out.println("unsorted student list");
        Q6StudentData.Trversedata(stdList);
        // using static cause traversing student data of whole class
        //rather than single object

        Q6StudentData.sortStudent(stdList);
        System.out.println("sorted student list on basis of marks");
        // using static cause sorting student data of whole class
        //rather than a single object
        //sorting on descending order

        Q6StudentData.Trversedata(stdList);
    }
}

class Q6StudentData implements Comparable<Q6StudentData>{
    String name;
    Double score;
    Integer age;
    Q6StudentData(String name,Double score,Integer age){
        this.name=name;
        this.score=score;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Q6StudentData{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", age=" + age +
                '}';
    }


    public static void Trversedata(List<Q6StudentData> stdList){
        for (Q6StudentData std:stdList) {
            System.out.println(std);
        }
    }

    public static void sortStudent(List<Q6StudentData> stdList){
        System.out.println("sorting students");
        Collections.sort(stdList);
    }


    @Override
    public int compareTo(@NotNull Q6StudentData o) {
        if(score>o.score){
            return -1;
        }
        else if(score<o.score){
            return 1;
        }
        else{
            return name.compareTo(o.name);
            //if score are equal compare on the basis of name
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}