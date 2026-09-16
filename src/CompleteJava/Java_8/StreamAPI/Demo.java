package CompleteJava.Java_8.StreamAPI;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(45, 47, 1, 48, 12, 3, 67, 90));

        list.stream()
                .filter(i -> i % 2 == 0)
                .sorted()
                .forEach(System.out::println);
    }
}
