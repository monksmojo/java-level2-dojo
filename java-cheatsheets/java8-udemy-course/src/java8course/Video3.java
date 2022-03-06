package java8course;

import java.util.stream.IntStream;

public class Video3 {
    public void imperativeApproach(){

        /*
          Imperative-how style of programming
          sum of first hundred numbers
          you focus on the how the result is
          the below program describes each and every step of
          iteration ant the variable is mutable on each step which makes
          it not thread safe
          explicitly mutating the sum variable
         */

        int sum=0;
        for (int i=0; i<=100; i++){
            sum+=i;
        }
        System.out.println("sum using Imperative Approach:"+sum);
    }

    public void declarativeApproach(){
        /*
          Declarative Style of Programming-:
          what style of programming
          sum of first hundred number
          you focus on what you want instead of how you want.
          the below only gives the output of what you need
          not care how result is provided to you
         */
        // parallel helps in multi threaded environment
        // comes under parallel programming
        int sum= IntStream.rangeClosed(0,100).parallel().sum();
        System.out.println("sum using the Declarative approach:"+sum);
    }
}
