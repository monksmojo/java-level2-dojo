package multithreading.exceptionHnadling;

public class Main {
    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("internal exception thrown");
            }
        });
        thread.setName("misbehaving thread");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                System.out.println("error appeared in thread-:"+ thread.getName());
                System.out.println("the error message is-:"+ thread.getName());
            }
        });
        thread.start();
    }
}
