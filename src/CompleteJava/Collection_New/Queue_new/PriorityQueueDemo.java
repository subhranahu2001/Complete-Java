package CompleteJava.Collection_New.Queue_new;

import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        //Part of the Queue interface
        // Orders elements based on their natural ordering (for primitive lowest first)
        //custom comparator for customised ordering
        //does not allow null elements

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(15);
        pq.add(10);
        pq.add(30);
        pq.add(4);

        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.peek());

        //internal working
        //Priority Queue is implemented as a min-heap by default(for natural Ordering)

    }
}
