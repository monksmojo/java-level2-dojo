//Q-6 Write a program to demonstrate sleep and join methods.
package MultithreadigExercise.Q6;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Q6sleepJoin t1=new Q6sleepJoin("sleepy-head");
        t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println("you will only see me after sleepy-head wakes up");

    }
}

class Q6sleepJoin extends Thread{
    Q6sleepJoin(String tname){
        super(tname);
    }

    public void run(){
        System.out.println(Thread.currentThread().getName());
        System.out.println("is going to sleep");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println("has waken up");
    }
}
