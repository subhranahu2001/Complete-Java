package CompleteJava.Collection_New.Set_New;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo {

    public static void main(String[] args) {
        //Thread safe
        //copy-on-write Mechanism
        //No duplicate element
        // Iterators do not reflect modifications

        CopyOnWriteArraySet<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<>();

        ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();
        for (int i = 1; i < 6; i++) {
            copyOnWriteArraySet.add(i);
            concurrentSkipListSet.add(i);
        }

        System.out.println("\n Iterating and modification copyOnWriteArraySet : ");
        for(Integer num : copyOnWriteArraySet) {
            System.out.println("Reading from copyOnWriteArraySet : " + num);
            //attemting to modify the set during iteration
            copyOnWriteArraySet.add(6);
        }
        System.out.println(copyOnWriteArraySet);

        System.out.println("\n Iterating and modification concurrentSkipListSet : ");
        for(Integer num : concurrentSkipListSet) {
            System.out.println("Reading from concurrentSkipListSet : " + num);
            //attemting to modify the set during iteration
            concurrentSkipListSet.add(6);
        }

    }
}
