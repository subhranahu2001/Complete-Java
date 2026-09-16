package CompleteJava.MultiThreading;

class MyThread extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("I am a lazy Thread");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            System.out.println("got Interrupted");
        }
    }
}

public class Interrupting_a_Thread {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        thread.interrupt();
    }
}

