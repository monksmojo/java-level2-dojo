//Q-8 Write a program to demonstrate the use of semaphore

package MultithreadigExercise.Q8;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException{
	// write your code here
        Semaphore mainsm=new Semaphore(1);
        Q8Permit obj1=new Q8Permit("increment",mainsm);
        Q8Permit obj2=new Q8Permit("decrement",mainsm);

        obj1.start();
        obj2.start();

        obj1.join();
        obj2.join();
        System.out.println("mian end");
    }
}

class Q8Permit extends Thread{
    private volatile static int count=11;
    private String tname;
    Semaphore q8sm;

    Q8Permit(String tname,Semaphore mainsm){
        super(tname);
        this.tname=tname;
        this.q8sm=mainsm;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"entered in run");
        if(tname.equals("increment")){
            System.out.println(tname+"executing");
            System.out.println("acquire semaphore permit");

            try {
                q8sm.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i=0; i<5; i++){
                Q8Permit.count+=1;
                System.out.println(tname+" "+count);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }//end of for
            System.out.println("releasing the permit");
            q8sm.release();

        }// end of if

        else{
            System.out.println(tname+"executing");
            System.out.println(tname+"executing");
            System.out.println("acquire semaphore");

            try {
                q8sm.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i=5; i>0; i--){
                Q8Permit.count-=1;
                System.out.println(tname+" "+count);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }//end of for

            System.out.println("releasing permit");
            q8sm.release();
        } // ennd of else
    } // end of run
}// end of class
