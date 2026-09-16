package CompleteJava.Collection_New.Queue_new;

import java.util.Comparator;
import java.util.concurrent.*;

class Producer implements Runnable {

    private BlockingQueue<Integer> queue;
    private int value = 0;
    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Producer produced : "+value);
                queue.put(value++);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer interrupted");
            }
        }
    }
}

class Consumer implements Runnable {

    private BlockingQueue<Integer> queue;
    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer value = queue.take();
                System.out.println("Consumer comsumed : "+value);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer interrupted");
            }
        }
    }
}

public class BlockingQueueDemo {

    public static void main(String[] args) {

        // A bounded blocking queue backed by circular array
        //single lock
        // thread safe queue
        //wait for queue to become non-empty/ wait for space
        //simplify concurrency problems like producer-consumer
        //standard queue -->immediately
        //empty --> remove(no waiting)
        //full --> add(no waiting)

        /// Blocking Queue
        //put -> Blocks if the queue is full until space becomes available
        //take -> Blocks if the queue is empty until an element becomes available
        //offer -> Wait for space to become available up to the specified timeout

        /*BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();*/


        BlockingQueue<Integer> queue2 = new LinkedBlockingQueue<>(5);
        // optionally bounded backed by LinkedList
        // uses two separate locks foe enqueue and dequeue operations
        // Higher concurrency between producers and consumer

        BlockingQueue<String> queue3 = new PriorityBlockingQueue<>(5, Comparator.reverseOrder());
        /// Binary Heap as array and can grow dynamically
        //head is based on their natural ordering or a provided comparator like priority queue
        //put don't block
        //unbounded
        queue3.add("apple");
        queue3.add("banana");
        queue3.add("cherry");
        System.out.println(queue3);

    }
}
