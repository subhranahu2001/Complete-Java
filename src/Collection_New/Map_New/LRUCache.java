package Collection_New.Map_New;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private int capacity;
    public LRUCache(int capacity) {
        super(capacity, 0.75f,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> lruCache = new LRUCache<>(3);
        lruCache.put("Bob",99);
        lruCache.put("Alice",89);
        lruCache.put("Ram",91);
        lruCache.put("Bob",100);
        lruCache.put("Vipul",89);

        System.out.println(lruCache);
    }
}
