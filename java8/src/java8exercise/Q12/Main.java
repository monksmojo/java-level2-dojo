//Find the first even number in the integer list which is greater than 3.
package java8exercise.Q12;

import javax.print.attribute.standard.NumberUp;
import javax.swing.plaf.IconUIResource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws Exception  {
	// write your code here
        try{
            System.out.println("executing Q-12");
            System.out.println("Find the first even number in the integer list which is greater than 3.");
            List<Integer> intList= Arrays.asList(1,2,3,14,15,16,10);
            if(intList.size()==0){
                throw new NullPointerException();
            }

            else {
                int result= intList.stream().filter(e->e%2==0 && e>3).findFirst().orElse(-1);
                if(result==-1){
                    System.out.println("no such integer found"+result);
                }// inner if
                else{
                    System.out.println("first even number greater than 3 is--->  "+result);
                }// inner else

            }// outer else


        }catch (Exception e){
            System.out.println("empty list passed as argument");
        }

        }

}

