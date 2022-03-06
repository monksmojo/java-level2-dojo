//Sum all the numbers greater than 5 in the integer list.
package java8exercise.Q10;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        try{
            System.out.println("executing Q-10");
            System.out.println("Sum all the numbers greater than 5 in the integer list.");
            List<Integer> intList= Arrays.asList(1,2,3,10,20,30);
            if(intList.size()==0){
                throw new Exception();
            }
            else{
               int sum= intList.stream().filter(e->e>5).mapToInt(e->e).sum();
                System.out.println("Sum all the numbers greater than 5 in the integer list"+sum);
            }
        }catch (Exception e){
            System.out.println(" empty integer list");
        }
    }
}
