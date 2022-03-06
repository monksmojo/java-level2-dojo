package multithreading.fixedThreadPool;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThroughputServer {
    private  String INPUT_FILE ;
    private  int NUMBER_OF_THREADS ;

    public ThroughputServer() throws IOException {
        this.INPUT_FILE="./resources/war_and_peace.txt";
        this.NUMBER_OF_THREADS=5;
        String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
        startServer(text);
    }

    public void startServer(String text) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/search", new WordCountHandler(text));
        Executor executor = Executors.newFixedThreadPool(this.NUMBER_OF_THREADS);
        server.setExecutor(executor);
        server.start();
    }

}
