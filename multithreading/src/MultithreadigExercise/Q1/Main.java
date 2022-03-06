//Q-1 Write a program do to demonstrate the use of volatile keyword.
package MultithreadigExercise.Q1;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("press enter to get out of executing state false");
        Q1Volatile obj1=new Q1Volatile("thread-1");
        obj1.start();

        Scanner input=new Scanner(System.in);
        input.nextLine();
        obj1.shutdown();
    }
}

class Q1Volatile extends Thread{
    volatile boolean execute=true;

    Q1Volatile(String threadName){
        super(threadName);// to set thread name
    }

    public void run(){
        while(execute){
            System.out.println(Thread.currentThread().getName()+" Executing");
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//end of while
    }//end of run function

    public void shutdown(){
        execute=false;
        System.out.println("stopped executing");
    }

}
