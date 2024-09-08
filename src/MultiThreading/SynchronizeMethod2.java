package MultiThreading;

class Display1 {
    public void displayN() {
        synchronized (Display1.class) {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
        }
    }

    public void displayC() {
        synchronized (Display1.class) {
            for (int i = 65; i <= 75; i++) {
                System.out.println((char) i);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e) {

                }
            }
        }
    }
}
class Th1 extends Thread {
    Display1 d;
    public Th1(Display1 d) {
        this.d = d;
    }
    public void run() {
        d.displayN();
    }
}

class Th2 extends Thread {
    Display1 d;
    public Th2(Display1 d) {
        this.d = d;
    }
    public void run() {
        d.displayC();
    }
}

public class SynchronizeMethod2 {

    public static void main(String[] args) {
        Display1 d = new Display1();
        new Th1(d).start();
        new Th2(new Display1()).start();
    }
}
