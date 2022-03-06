//Run a task with the help of callable and store it's result in the Future

package MultithreadigExercise.Q7;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(1);

        CallCenter operator1 = new CallCenter();

        System.out.println("Getting the status code: ");
        Future<Integer> future = pool.submit(operator1);
        Integer result = future.get();
        System.out.println("Print the status code: ");
        System.out.println(result);
        pool.shutdown();

        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class CallCenter implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("Returning Integer value of Callable Interface ");
        return 5;
    }
}

