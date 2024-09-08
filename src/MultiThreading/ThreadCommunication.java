package MultiThreading;

class Calculation extends Thread {

    int count = 0;
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("Child Thread starts calculation :");
            for (int i = 1; i <= 10; i++) {
                count += i;
            }
            System.out.println("Child Thread ends calculation :");
            this.notify();
        }

    }
}

public class ThreadCommunication {

    public static void main(String[] args) throws InterruptedException {
        Calculation cal = new Calculation();
        cal.start();
        synchronized (cal) {
            System.out.println("Main thread call wait method :");
            cal.wait();
            System.out.println("Main thread got notification :");
            System.out.println(cal.count);
        }
    }

}
