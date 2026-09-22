package Complete_Revesion.MultiThreading;

public class SynchronizationDemo_1 {

    public static void main(String[] args) {
        Thread t1 = new Thread();

        inner();
    }

    public static synchronized void inner() {
        outer();
        System.out.println("inner");
    }
    public static synchronized void outer() {
        System.out.println("outer");
    }
}
