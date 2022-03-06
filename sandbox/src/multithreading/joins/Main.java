package multithreading.joins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Long> inputNumbers= Arrays.asList(0L,343L,3534L,2112L,12L);

        List<FactorialThread> factorialThreadList =new ArrayList<>();
        for (Long inputNumber:inputNumbers) {
            factorialThreadList.add(new FactorialThread(inputNumber));
        }

        for (FactorialThread factorialThread:factorialThreadList) {
            factorialThread.start();
        }

        for (FactorialThread factorialThread:factorialThreadList) {
            try{
                factorialThread.join();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        for (int i=0; i<inputNumbers.size(); i++){
            FactorialThread factorialThread=factorialThreadList.get(i);
            if(factorialThread.isFinished()){
                System.out.println("factorial of "+factorialThread.getFactorialOf()+" is "+factorialThread.getResult());
            }
            else{
                System.out.println("factorial of "+factorialThread.getFactorialOf()+" is processing");
            }
        }


    }
}
