package MultiThreading;
class Thread2 extends Thread {
    static Thread t;
    @Override
    public void run() {
        try {
            t.join();
            System.out.println("child thread");
        } catch (InterruptedException e) {

        }
    }
}
public class Deadlock {

    public static void main(String[] args) throws InterruptedException {
//        Thread2.t = Thread.currentThread();
//        Thread t1 = new Thread2();
//        t1.start();
//        t1.join();

        /**
        * in simple
        * */
        Thread.currentThread().join();


    }
}
