package MultiThreading;

class SharedResource {
    private int data;
    private boolean isData;

    public synchronized void produce(int value) {
        while (isData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        isData = true;
        System.out.println("Produced " + value);
        notify();
    }

    public synchronized int consume() {
        while (!isData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        isData = false;
        System.out.println("Consumed " + data);
        notify();
        return data;
    }

}

class Producer implements Runnable {
    private final SharedResource sharedResource;
    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            sharedResource.produce(i);
        }
    }
}
class Consumer implements Runnable {
    private final SharedResource sharedResource;
    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            sharedResource.consume();
        }
    }
}

public class InterThreadCommunication {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread producer = new Thread(new Producer(sharedResource));
        Thread consumer = new Thread(new Consumer(sharedResource));
        producer.start();
        consumer.start();
    }
}
