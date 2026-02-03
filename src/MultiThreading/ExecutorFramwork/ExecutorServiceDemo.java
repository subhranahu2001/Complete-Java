package MultiThreading.ExecutorFramwork;

import java.util.concurrent.*;

public class ExecutorServiceDemo {

    static Callable<Integer> r = () -> {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        return sum;
    };

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> f = executorService.submit(r);
        System.out.println(f.get());
        executorService.shutdown();


    }
}
