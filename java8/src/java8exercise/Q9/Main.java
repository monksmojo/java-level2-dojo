//Collect all the even numbers from an integer list.
package java8exercise.Q9;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
	try{
        List<Integer> intList= Arrays.asList(10,2,30,4,15,6,17);
        if(intList.size()==0){
            throw new Exception();
        }
        else{
            System.out.println(intList.stream().filter(e->e%2==0).collect(Collectors.toList()));
        }
    }catch (Exception e){
        System.out.println("empty list passed");
        System.out.println(e);
    }

    }
}
