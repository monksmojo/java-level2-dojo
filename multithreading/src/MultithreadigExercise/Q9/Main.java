//Write a program to demonstrate the use of CountDownLatch

package MultithreadigExercise.Q9;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {
        CountDownLatch latch=new CountDownLatch(3);

        lapRace car1=new lapRace("audi",latch);
        lapRace car2=new lapRace("bat mobile",latch);
        lapRace car3=new lapRace("cybertruck",latch);
        car1.start();
        car2.start();
        car3.start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("race ended");
    }
}

class lapRace extends Thread{
    private CountDownLatch latch;

    lapRace(String carName, CountDownLatch latch){
        super(carName);
        this.latch=latch;
    }

    public void run(){
        System.out.println(this.getName()+"started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
        System.out.println(this.getName()+"ended");
    }
}
