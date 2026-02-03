package MultiThreading.Completable_Future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executorService =
                Executors.newFixedThreadPool(10);

        Future<List<Integer>> future =
                executorService.submit(() -> {
                    System.out.println(Thread.currentThread().getName());
                    delay(10);
                    return Arrays.asList(1, 2, 3, 4, 5);
                });

        List<Integer> list = null;
        try {
            list = future.get(2, TimeUnit.SECONDS);
            System.out.println(list);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }




    }

    private static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
