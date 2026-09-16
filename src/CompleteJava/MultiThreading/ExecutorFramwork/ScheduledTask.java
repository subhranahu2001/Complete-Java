package CompleteJava.MultiThreading.ExecutorFramwork;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTask{

    public static void main(String[] args) {
        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(
                () -> System.out.println("Task executed after every 5 seconds delay"),
                5,
                5,
                TimeUnit.SECONDS
                );

        scheduler.schedule(() -> {
            System.out.println("Initiating shutdown");
            scheduler.shutdown();
        },20,TimeUnit.SECONDS);
    }


}
