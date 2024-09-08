package MultiThreading;

class Display{
    public static synchronized void wish(String name) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.print("Good Morning : ");
            Thread.sleep(1000);
            System.out.println(name);
        }
    }
}

public class SynchronizeMethod extends Thread{

    Display d;
    String name;
    public SynchronizeMethod(Display d, String name) {
        this.d = d;
        this.name = name;
    }
    public void run() {
        try {
            d.wish(name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Display d = new Display();
        new SynchronizeMethod(d, "silu").start();
        new SynchronizeMethod(new Display(), "barik").start();
    }

}
