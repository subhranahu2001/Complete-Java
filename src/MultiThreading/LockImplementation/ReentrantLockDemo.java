package MultiThreading.LockImplementation;

import java.util.concurrent.locks.ReentrantLock;

class Demo {

    private final ReentrantLock lock = new ReentrantLock();

    public void outerMethod() {
        lock.lock();

            try {
                System.out.println("outer method");
                innerMethod();
            } finally {
                lock.unlock();
            }
    }
    public void innerMethod() {
            lock.lock();
            try {
                System.out.println("inner method");
            }finally {
                lock.unlock();
            }

    }
}
public class ReentrantLockDemo {

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.outerMethod();
    }
}
