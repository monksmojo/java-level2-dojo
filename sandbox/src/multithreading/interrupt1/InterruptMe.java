package multithreading.interrupt1;

public class InterruptMe implements Runnable {
    @Override
    public void run() {
        System.out.println("running thread "+Thread.currentThread().getName());
        try{
            System.out.println("thread sleeping "+Thread.currentThread().getName());
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+ " interrupted");
            e.printStackTrace();
        }
    }
}
