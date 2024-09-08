package MultiThreading.LockImplementation;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Display {

    private static Lock lock = new ReentrantLock();

    public void wish(String name) {

        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.print("Good Morning : ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name);
        }
        lock.unlock();
    }
}

class MyThread implements Runnable {

    private Display display;
    private String name;
    public MyThread(Display display, String name) {
        this.display = display;
        this.name = name;
    }
    @Override
    public void run() {
        display.wish(name);
    }
}

public class LockImplementation {

    public static void main(String[] args) {
        Display display = new Display();
        MyThread t1 = new MyThread(display, "silu");
        MyThread t2 = new MyThread(new Display(), "subhranshu");
        new Thread(t1).start();
        new Thread(t2).start();
    }
}
