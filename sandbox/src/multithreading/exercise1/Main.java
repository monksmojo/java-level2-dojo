package multithreading.exercise1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Runnable> runnableList= Arrays.asList(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("1 st thread");
                System.out.println(Thread.currentThread().getName()+ "running");
            }
        }, new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("2 nd thread");
                System.out.println(Thread.currentThread().getName()+ "running");
            }
        });
        MultiExecutor multiExecutor=new MultiExecutor(runnableList);
        multiExecutor.executeAll();
    }
}
