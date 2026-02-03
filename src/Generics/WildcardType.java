package Generics;

import java.util.List;

public class WildcardType {

    public static void main(String[] args) {
        double sum = sum(List.of(1, 2, 3, 4, 5,2.78,1.07));
        System.out.println(sum);
    }

    public static double sum(List<? extends Number> numbers) {
        double sum = 0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
}
