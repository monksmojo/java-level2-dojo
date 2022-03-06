//Q-10 Write a program which creates deadlock between 2 threads
package MultithreadigExercise.Q10;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Producer producerObject=new Producer();
        Consumer consumerObject=new Consumer();
        Thread threadOne=new Thread(){
            public void run(){
                producerObject.producerMethod(consumerObject);
            }
        };
        Thread threadTwo=new Thread(){
            public void run(){
                consumerObject.consumerMethod(producerObject);
            }
        };

        threadOne.start();
        threadTwo.start();
    }
}

class Consumer{
    public synchronized void consumerMethod(Producer p){
        System.out.println(Thread.currentThread().getName() + "Trying to execute producer class method ");
        try{
            Thread.sleep(500);
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
        p.display();
    }
    public synchronized void display(){
        System.out.println("Invoking display method of consumer");
    }
}
class Producer{
    public synchronized void producerMethod(Consumer c){
        System.out.println(Thread.currentThread().getName() + "Trying to execute consumer class method ");
        try{
            Thread.sleep(500);
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
        c.display();
    }


    public synchronized void display(){
        System.out.println("Invoking display method of producer");
    }
}

