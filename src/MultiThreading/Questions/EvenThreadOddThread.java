package MultiThreading.Questions;

//class EvenOddThread extends Thread {
//
//    String name;
//    Object object;
//
//    EvenOddThread(String name, Object object) {
//        super(name);
//        this.name = name;
//        this.object = object;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i <= 10; i++) {
//
//            if (i % 2 == 0 && Thread.currentThread().getName().equalsIgnoreCase("even")) {
//                synchronized (object) {
//                    System.out.println(Thread.currentThread().getName() + " " + i);
//
//                    try {
//                        object.wait();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            } else if (i % 2 != 0 && Thread.currentThread().getName().equalsIgnoreCase("odd")) {
//                System.out.println(Thread.currentThread().getName() + " " + i);
//                synchronized (object) {
//                    object.notify();
//                }
//                if (i == 10) {
//                    break;
//                }
//            }
//        }
//    }
//

record PrintNo(Object object) implements Runnable {

    static int counter = 1;

    @Override
    public void run() {

        while (counter <= 100) {
            if (counter % 2 == 0 && Thread.currentThread().getName().equalsIgnoreCase("even")) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + "..." + counter);
                    counter++;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            if (counter % 2 != 0 && Thread.currentThread().getName().equalsIgnoreCase("odd")) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + "..." + counter);
                    counter++;
                    object.notify();
                }
            }
        }
    }
}





public class EvenThreadOddThread {

    public static void main(String[] args) {
        Object lock = new Object();
        Runnable r1 = new PrintNo(lock);
        Runnable r2 = new PrintNo(lock);
        new Thread(r1,"even").start();
        new Thread(r2,"odd").start();
    }
}
