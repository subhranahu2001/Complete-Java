package Complete_Revesion.MultiThreading;

public class MultipleWayToCreateThread {

    public static void main(String[] args) {

        //1
        Thread t1 = new Thread(new Thread1());
        t1.start();

        //2
        Thread t2 = new Thread2("Thread 2");
        t2.start();

        //3
        Thread t3 = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        t3.start();

        //4
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "anonymous theread ");
            }
        }).start();
    }
}

/// Implementing Runnable interface
class Thread1 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Thread1 is running");
    }
}

class Thread2 extends Thread {

    public Thread2(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Thread2 is running");
    }
}