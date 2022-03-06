package multithreading.creation1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("we are now in thread-->"+Thread.currentThread().getName());
                System.out.println("current thread priority is-->"+Thread.currentThread().getPriority());
            }
        });
        thread.setName("runnable interface thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.setPriority(Thread.NORM_PRIORITY);


        System.out.println("thread name-->"+Thread.currentThread().getName() + " before starting the "+thread.getName());
        thread.start();
        System.out.println("thread name-->"+Thread.currentThread().getName() + " after ending the "+thread.getName());

        Thread.sleep(10000);
    }
}
