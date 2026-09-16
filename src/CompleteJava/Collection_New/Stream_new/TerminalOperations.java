package CompleteJava.Collection_New.Stream_new;

import java.util.Arrays;
import java.util.List;

public class TerminalOperations {

    public static void main(String[] args) {

        // reduce --> return only one value
        //summing values
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(integers.stream().reduce( Integer::sum).get());


    }
}
