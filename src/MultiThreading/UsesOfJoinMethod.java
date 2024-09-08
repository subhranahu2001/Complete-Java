package MultiThreading;

class Thread1 extends Thread {

    static Thread child;

    public void run() {
        try {
            child.join();
            for (int i = 0; i < 5; i++) {
//                Thread.sleep(2000);
                System.out.println("Child Thread");
            }
        } catch (InterruptedException e) {
            e.getCause();
        }
    }
}
public class UsesOfJoinMethod {


    public static void main(String[] args) throws InterruptedException {
        Thread1.child = Thread.currentThread();
        Thread t1 = new Thread1();
        t1.start();

        // if we want to main thread wait
//        t1.join();

        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread");
            Thread.sleep(2000);
        }
    }
}
