package multithreading.executorservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main{
    public static void main(String[] args) {
        List<Long> longNumberList =Arrays.asList(212L, 45L,56L,90L);
        ExecutorService executorService= Executors.newFixedThreadPool(4);
        for(Long number: longNumberList){
            BigFactorial worker=new BigFactorial(number);
            executorService.execute(worker);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        BigFactorial.getResultList().forEach(System.out::println);
    }
}
