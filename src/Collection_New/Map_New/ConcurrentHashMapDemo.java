package Collection_New.Map_New;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map =
                new ConcurrentHashMap<String, Integer>();
        // java 7 --> segment based locking  ---> smaller hashmaps
        // Only the segment being written to or read from is locked
        // read: don not require locking unless there is a written operation happening on the same segment
        //write: lock


        // java-8 --> no segmentation
        //      ---> Compare and swapping approach --> no locking except resizing or collision

        // it is concurrent version of hashmap

    }
}
