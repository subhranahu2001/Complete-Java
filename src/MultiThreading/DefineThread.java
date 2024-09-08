package MultiThreading;

public class DefineThread {

    public static void main(String[] args) {
        new Thread(new Mythread1()).start();

        // Using lambda function
        new Thread(() -> {
            System.out.println("Define Thread");
        }).start();
        System.out.println(Thread.currentThread().getState());
        Thread.yield();
    }
}

class Mythread1 extends Thread {
    public void run() {
        // Code to be executed in the thread
        System.out.println("Child thread");
    }

}
