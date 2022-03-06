//Q-4 Write a program using synchronization block and synchronization method

package MultithreadigExercise.Q3;

public class Main {

    public static void main(String[] args) {
	Thread t1=new Thread(new Q3Syncronized(),"thread-1");
	Thread t2=new Thread(new Q3Syncronized(),"thread-2");
	t1.start();
	t2.start();

    }
}

class Q3Syncronized implements Runnable{

    @Override
    public void run() {
        this.block1();
        this.block2();
    }

    // synchronized method
    synchronized void  block1(){
        System.out.println("\n"+Thread.currentThread().getName()+" executing inside synchronized method");
        for(int i=0; i<5; i++){ System.out.print(i+""); }

        System.out.println("\n"+Thread.currentThread().getName()+" exiting synchronized method");
    }

    void block2(){
        //synchronized block
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+"inside synchronized block");
            for(int i=0; i<3; i++){
                System.out.print(i+"");
            }

            System.out.println("\n"+Thread.currentThread().getName()+" exiting sync block");
        }
    }
}