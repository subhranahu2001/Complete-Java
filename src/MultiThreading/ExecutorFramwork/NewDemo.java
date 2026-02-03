package MultiThreading.ExecutorFramwork;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class NewDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();

//        Future<Integer> submit = executorService.submit(() -> 42);
//        System.out.println(submit.get());
//        executorService.shutdown();
        Callable<Integer> callable1 = () -> {
            Thread.sleep(1000);
            return 1;
        };
        Callable<Integer> callable2 = () -> {
            Thread.sleep(1000);
            return 2;
        };
        Callable<Integer> callable3 = () -> {
            Thread.sleep(1000);
            return 3;
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Future<Integer>> futures = executorService.invokeAll(Arrays.asList(callable1,callable2,callable3),1,TimeUnit.SECONDS);
        for (Future<Integer> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | CancellationException e) {

            }
        }
        executorService.shutdown();


    }
}
