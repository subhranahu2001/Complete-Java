package CompleteJava.MultiThreading.ExecutorFramwork;

import java.util.concurrent.*;

public class CountDownLatchDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numberOfThreads = 3;

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        CountDownLatch countDownLatch = new CountDownLatch(numberOfThreads);

        executor.submit(new MyThread(countDownLatch));
        executor.submit(new MyThread(countDownLatch));
        executor.submit(new MyThread(countDownLatch));
        countDownLatch.await();

        System.out.println("Main");
        executor.shutdown();

    }
}

class MyThread implements Callable<String> {
    private final CountDownLatch countDownLatch;

    public MyThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + " service started :");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            countDownLatch.countDown();
        }
        return "ok";
    }
}
