package multithreading.casestudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static final int Max_Password=999;
    public static void main(String[] args) {
        Random random=new Random();
        Vault vault=new Vault(random.nextInt(Max_Password));
        List<Thread> threadList=new ArrayList<>();

        threadList.add(new AscHackerThread(vault));
        threadList.add(new DescHackerThread(vault));
        threadList.add(new PoliceThread());

        for (Thread thread:threadList) {
            thread.start();
        }
    }
}
