package MultiThreading.ExecutorFramwork;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int numberOfSubSystems = 4;

        CyclicBarrier cyclicBarrier =
                new CyclicBarrier(numberOfSubSystems,
                        () -> System.out.println("All subSystem are up and running. System startup complete")
                );

        Thread webServerThread = new Thread(new SubSystem("web server",2000,cyclicBarrier));
        Thread databaseThread = new Thread(new SubSystem("database Thread",4000,cyclicBarrier));
        Thread cacheThread = new Thread(new SubSystem("cache Thread",3000,cyclicBarrier));
        Thread messagingThread = new Thread(new SubSystem("messaging service",3500,cyclicBarrier));

        webServerThread.start();
        databaseThread.start();
        cacheThread.start();
        messagingThread.start();

    }

}

class SubSystem implements Runnable {

    private String name;

    private int initializationTime;

    private CyclicBarrier cyclicBarrier;

    public SubSystem(String name, int initializationTime, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.initializationTime = initializationTime;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        try {
            System.out.println(name + " initialization started ");
            Thread.sleep(initializationTime);
            System.out.println(name + " initialization completed ");
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
