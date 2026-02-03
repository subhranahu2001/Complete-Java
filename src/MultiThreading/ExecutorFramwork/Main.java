package MultiThreading.ExecutorFramwork;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

//        Thread[] threads = new Thread[9];
        ExecutorService executorService = Executors.newFixedThreadPool(9);
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            executorService.submit(() -> {
                long result = factorial(finalI);
                System.out.println(Thread.currentThread().getName()+"...."+result);
            });
        }
        executorService.shutdown();

        System.out.println("Total time : " +(System.currentTimeMillis() - startTime));

    }

    public static long factorial(int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
