package java8course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Video4 {
    // imperative and declarative type of programing example 2
    // remove duplicates from Integers
    List<Integer> integerList= Arrays.asList(1,2,3,4,5,6,7,8,1,2,3);
    public void imperativeApproach(){
        List<Integer> uniqueList=new ArrayList<>();
        for (Integer intNumber:integerList) {
            if(!uniqueList.contains(intNumber)){
                uniqueList.add(intNumber);
            }
        }
        /**
         * we focus on how the unique list is being generated
         * we write how to find unique the logic
         */
        System.out.println("unique list ");
        System.out.println("using imperative approach"+uniqueList);
    }

    public void declarativeApproach(){
//        List<Integer> uniqueList=new ArrayList<>();
        /**
         * we only focus on the result what is the result of the of function
         */
        List<Integer> uniqueList=integerList.stream().distinct().collect(Collectors.toList());
        System.out.println("unique list ");
        System.out.println("using declarative approach"+uniqueList);
    }
}
