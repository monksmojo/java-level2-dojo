package multithreading.casestudy;

public class PoliceThread extends Thread {

    PoliceThread(){
        super("lock down started");
    }

    @Override
    public void run() {
        System.out.println(this.getName());
        for (int i=10; i>0; i--){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }

        System.out.println("backdoor closed");
        System.exit(0);
    }
}
