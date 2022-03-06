//Q-2 Write a program to create a thread using Thread class and Runnable interface each.
package MultithreadigExercise.Q2;

public class Main {

    public static void main(String[] args) {
        // write your code here

        MakeThread1 obj1=new MakeThread1("extended thread");
        obj1.start();
        try{
            obj1.join(); // wait for thread to end to end
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t1=new Thread( new MakeThread2(),"runnable thread");
        // first argument is the class object
        // second argument is thread name
        t1.start();
        try{
            t1.join(); // wait for obj-1 to end
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"stops");
    }
}

class MakeThread1 extends Thread{
    MakeThread1(String threadName){
        super(threadName);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" executing");
        for(int i=0; i<5; i++)
            System.out.print(i+" ");

        System.out.println("\n"+Thread.currentThread().getName()+" stops");
    }
}

class MakeThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" executing");
        for(int i=0; i<3; i++)
            System.out.print(i+" ");

        System.out.println("\n"+Thread.currentThread().getName()+" stops");
    }
}