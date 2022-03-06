//Q-5 Write a program to demonstrate wait and notify methods.
package MultithreadigExercise.Q5;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // write your code here
        Q5Cycle obj1 = new Q5Cycle();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.currentThread().setName("waiting-thread");
                    obj1.goWait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } // end of run method
        });// end of t1

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().setName("notify-thread");
                    obj1.notifyMe();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } // end of run
        }); // end of t2

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("main ended");
    }// end of main
}

class Q5Cycle {
    public void goWait() throws InterruptedException {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName());
            System.out.println("going to wait");
//            wait();

            System.out.println("wait ended");
        }
    }

    public void notifyMe() throws InterruptedException {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName());
            System.out.println("sending notification");
            notify();
            System.out.println("notification send");
        }
    } // end of notify me
}