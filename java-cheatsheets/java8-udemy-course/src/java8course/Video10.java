package java8course;

public class Video10 implements Runnable {

    // prior java 8 runnable interface
    @Override
    public void run() {
        System.out.println("inside video 10 runnable interface");
    }

    // runnable interface using lambda interface
    public Runnable lambda1=()->{
        System.out.println("inside runnable lambda 1");
    };

    public Runnable lambda2=()-> System.out.println("inside runnable lambda2");
}
