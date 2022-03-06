//Q-4 Write a program to create a Thread pool of 2 threads
//where one Thread will print even numbers and other will print odd numbers.
package MultithreadigExercise.Q4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ThreadTask t1=new ThreadTask("even-thread");
        ThreadTask t2=new ThreadTask("odd-thread");
        executor.submit(t1);
        executor.submit(t2);

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadTask extends Thread{
    private String threadName;

    ThreadTask(String threadName){
        this.threadName=threadName;
    }

    public void run(){
        if(threadName.equals("even-thread")){
            System.out.println("\n"+threadName+" executing even loop");
            for (int i=0; i<=10; i++){
                if(i%2==0)
                    System.out.print(i);
            }
        }// end of even iteration

        if(threadName.equals("odd-thread")){
            System.out.println("\n"+threadName+" executing odd loop");
            for (int i=0; i<=10; i++){
                if(i%2!=0)
                    System.out.print(i);
            }
        }// end of odd iteration
    } //end of run
} // end of ThreadTask
