package multithreading.interrupt1;

public class Main {
    public static void main(String[] args) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        Thread thread=new Thread(new InterruptMe());
        thread.setName("rabbit thread");
        thread.start();
        thread.interrupt();

    }
}
