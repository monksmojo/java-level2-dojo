//Implement following functional interfaces from java.util.function using lambdas:
// (1) Consumer
// (2) Supplier
// (3) Predicate
// (4) Function
package java8exercise.Q5;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        List<Integer> intList= Arrays.asList(1,2,3,7,8,9);
        System.out.println("Using consumer interface");
        Consumer con=(e)->{ System.out.println(e); };

        con.accept(intList);

        System.out.println("Using supplier interface");
        Supplier<String> sup=()->{
            return "calling from supplier";
        };
        System.out.println(sup.get());

        System.out.println("Using predicate interface");
        Predicate<Integer> pre=(e)->{
          return e%2==0;
        };
        System.out.println(pre.test(4));

        System.out.println("Using Function interface");
        Function<Integer,Integer> function=(e)->{
          return e*2;
        };
        System.out.println(function.apply(4));
    }

}
