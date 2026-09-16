package CompleteJava.MultiThreading.ExecutorFramwork;

import java.util.concurrent.*;

public class FutureMethods {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future = executorService.submit(() -> {
            Thread.sleep(2000);
            return 20;
        });


        try {
            int i = future.get(1, TimeUnit.SECONDS);
            System.out.println(future.isDone());
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            System.out.println("Exception: " + e);
        } finally {
            executorService.shutdown();
        }


    }
}
