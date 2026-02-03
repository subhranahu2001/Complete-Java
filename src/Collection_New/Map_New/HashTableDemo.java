package Collection_New.Map_New;

import java.util.Hashtable;

public class HashTableDemo {

    public static void main(String[] args) throws InterruptedException {

        Hashtable<Integer,String> ht = new Hashtable<>();
        // Hash table is synchronized
        // Only LinkedList in case of collision

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ht.put(i, "" + i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ht.put(i, "thread");
            }
        });
        t1.start();
        Thread.sleep(1000);
        t2.start();
        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("map size: " + ht.size());
        System.out.println(ht);

    }
}
