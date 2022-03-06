package multithreading.fixedThreadPool;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            ThroughputServer throughputServer = new ThroughputServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
