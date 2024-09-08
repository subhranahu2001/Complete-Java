package MultiThreading;



class Counter {
    int counter = 0;
    public void increment() {
        synchronized (this) {
            counter++;
        }
    }
    public int getCounter() {
        return counter;
    }
}

public class SynchronizedDemo extends Thread {

    private Counter counter;
    public SynchronizedDemo(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }

    public static void main(String[] args) {


        Counter counter = new Counter();
        Thread t1 = new SynchronizedDemo(counter);
        Thread t2 = new SynchronizedDemo(counter);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {

        }

        System.out.println(counter.getCounter());
    }
}
