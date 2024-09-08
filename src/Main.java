//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{

    static Runnable oddThread = () -> {
        for (int i = 1; i <= 10 ; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName()+".." + i);
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(oddThread);
        t.start();
        t.join();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+".." + i);
            }
        }
    }
}
