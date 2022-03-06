package multithreading.executorservice;

import java.util.ArrayList;
import java.util.List;

public class BigFactorial implements Runnable  {
    private long factorialOf;
    private long factorialResult;
    private static List<Long> resultList=new ArrayList<>();

    BigFactorial(long factorialOf){
        this.factorialOf=factorialOf;
        this.factorialResult=1L;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(factorialOf);
        for (long i = factorialOf; i > 0; i--) {
            factorialResult=factorialResult*factorialOf;
        }
        this.getFactorialResult(factorialResult);
    }

    public void getFactorialResult(Long factorialResult) {
        resultList.add(factorialResult);
    }

    public static List<Long> getResultList() {
        return resultList;
    }
}
