//Find average of the number inside integer list after doubling it.
package java8exercise.Q11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
	// write your code here
        try {
            System.out.println("executing Q-11");
            System.out.println("Find average of the number inside integer list after doubling it.");
            List<Integer> intList= Arrays.asList(10,20,30);
            if(intList.size()==0){
                throw new  Exception();
            }
            else{
                double result=intList.stream().collect(Collectors.averagingInt(e->e*2));
                System.out.println("average of "+intList+"after double is-->"+result);
            }

        }catch (Exception e){
            System.out.println("empty list passed");
        }

    }
}
