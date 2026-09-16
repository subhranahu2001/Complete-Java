package CompleteJava.Collection_New.Queue_new;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        // Thread safe unblocking queue
        // Elements can only be taken from the queue when their delay has expired
        // Useful for scheduling tasks to be executed after a certain delay
        // internally priority queue
        BlockingQueue<DelayedTask> queue = new DelayQueue<>();
        queue.put(new DelayedTask("task1",5,TimeUnit.SECONDS));
        queue.put(new DelayedTask("task2",3,TimeUnit.SECONDS));
        queue.put(new DelayedTask("task3",10,TimeUnit.SECONDS));

        while (!queue.isEmpty()) {
            DelayedTask task = queue.take();
            System.out.println("Executed: "+task.getTaskName()+" at "+System.currentTimeMillis());
        }
    }
}

class DelayedTask implements Delayed {

    private final String taskName;
    private final long startTime;

    public DelayedTask(String taskName, long delay,TimeUnit timeUnit) {
        this.taskName = taskName;
        this.startTime = System.currentTimeMillis() + timeUnit.toMillis(delay);
    }

    @Override
    public int compareTo(Delayed o) {
        if (this.startTime < ((DelayedTask)o).startTime) {
            return -1;
        }
        if (this.startTime > ((DelayedTask)o).startTime) {
            return 1;
        }
        return 0;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long remaining = startTime - System.currentTimeMillis();
        return unit.convert(remaining, TimeUnit.MILLISECONDS);
    }

    public String getTaskName() {
        return taskName;
    }
}
