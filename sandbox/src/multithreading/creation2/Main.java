package multithreading.creation2;

public class Main {
    public static void main(String[] args) {
        MyThread myThread=new MyThread("thread by Extending Thread");
        myThread.start();
    }
}
