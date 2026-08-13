package Java_8.StreamAPI.Cluad;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamPerformance {


    public static void main(String[] args) {
        List<Integer> bigList = IntStream.range(0, 10_000_000)
                .boxed()
                .collect(Collectors.toList());

// Sequential
        long start1 = System.nanoTime();
        long sum1 = bigList.stream()
                .mapToLong(Integer::longValue)
                .sum();
        long time1 = System.nanoTime() - start1;

// Parallel
        long start2 = System.nanoTime();
        long sum2 = bigList.parallelStream()
                .mapToLong(Integer::longValue)
                .sum();
        long time2 = System.nanoTime() - start2;

        System.out.println("Sequential: " + time1 / 1_000_000 + " ms");
        System.out.println("Parallel: " + time2 / 1_000_000 + " ms");


    }
    public boolean isPalindrome(String str) {
        String clean = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        return IntStream.range(0, clean.length() / 2)
                .noneMatch(i -> clean.charAt(i) != clean.charAt(clean.length() - 1 - i));
    }
}
