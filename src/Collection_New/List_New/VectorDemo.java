package Collection_New.List_New;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class VectorDemo {

    public static void main(String[] args) throws InterruptedException {
        Vector<Integer> vector1 = new Vector<>();
//        List<Integer> vector = new Vector<>();
        List<Integer> vector = Collections.synchronizedList(vector1);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                vector.add(i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                vector.add(i);
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {

        }

        System.out.println(vector.size());

    }
}
