package Collection_New.Queue_new;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue<String>();

        Thread producer = new Thread(() -> {
            try {
                System.out.println("Producer is waiting to transfer :");
                queue.put("Hello from producer");
                System.out.println("Producer has transferred the msg");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer interrupted");
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                System.out.println("Consumer is waiting to recive :");
                String message = queue.take();
                System.out.println("Consumer recived : " + message);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer interrupted");
            }
        });
        producer.start();
        consumer.start();
    }
}
