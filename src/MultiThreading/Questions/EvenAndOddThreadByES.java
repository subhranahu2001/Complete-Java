package MultiThreading.Questions;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class EvenAndOddThreadByES {

//    public static void main(String[] args) {
//
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//
//        IntStream.rangeClosed(1,10)
//                .forEach(num -> {
//                    CompletableFuture<Integer> oddCompletableFuture = CompletableFuture.completedFuture(num)
//                            .thenApplyAsync(x -> {
//                                if (x % 2 != 0) {
//                                    System.out.println(Thread.currentThread().getName()+".."+x);
//                                }
//                                return num;
//                            },executor);
//                    oddCompletableFuture.join();
//
//                    CompletableFuture<Integer> evenCompletableFuture = CompletableFuture.completedFuture(num)
//                            .thenApplyAsync(x -> {
//                                if (x % 2 == 0) {
//                                    System.out.println(Thread.currentThread().getName()+".."+x);
//                                }
//                                return num;
//                            },executor);
//                    evenCompletableFuture.join();
//                });
//        executor.shutdown();
//    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletableFuture<?>[] futures = IntStream.rangeClosed(1,10)
                .mapToObj(num -> CompletableFuture.runAsync(() -> {
                    // check the no is odd
                    if (num % 2 != 0) {
                        System.out.println(Thread.currentThread().getName()+"..odd : "+num);
                    }
                    if (num % 2 == 0) {
                        System.out.println(Thread.currentThread().getName()+"..even : "+num);
                    }
                },executor))
                .toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(futures).join();
        executor.shutdown();
    }
}
