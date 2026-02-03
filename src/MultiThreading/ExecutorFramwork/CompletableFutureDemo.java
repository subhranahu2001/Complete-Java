package MultiThreading.ExecutorFramwork;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

    public static void main(String[] args) {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Worker Thread");
            } catch (InterruptedException e) {

            }
            return "ok";
        }).thenApply(x -> x+x).exceptionally(throwable -> "exception");

        try {
            future.get();
//            future.join();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println("main ");


    }
}
