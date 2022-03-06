package multithreading.creation2;

public class MyThread extends Thread{

    MyThread(String threadName){
        super(threadName);
    }

    @Override
    public void run() {
        System.out.println("inside thread-->"+this.getName());
        System.out.println("with priority"+this.getPriority());
    }
}
