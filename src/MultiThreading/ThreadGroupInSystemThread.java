package MultiThreading;

public class ThreadGroupInSystemThread {

    public static void main(String[] args) {
        ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
        System.out.println(system.getName());

        Thread[] t = new Thread[system.activeCount()];
        system.enumerate(t);
        for (Thread t1 : t) {
            System.out.println(t1.getName()+"====="+t1.getState()+"===="+t1.isDaemon());
        }
    }
}
