package CompleteJava.Collection_New.Map_New;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {

    public static void main(String[] args) {
        SortedMap<Integer,String> map = new TreeMap<>((a,b) -> b - a);
        // Read Black Tree(self Balancing Binary Search Tree)

        map.put(91,"Vivek");
        map.put(99,"Subham");
        map.put(78,"Moihit");
        map.put(60,"Silu");

        System.out.println(map);

//        System.out.println(map.firstKey());
//        System.out.println(map.lastKey());
//        System.out.println(map.tailMap(91));
//        System.out.println(map.headMap(91)); // it does not include toKey

        NavigableMap<Integer,String> navigableMap = new TreeMap<>();

        navigableMap.put(1,"One");
        navigableMap.put(5,"Five");
        navigableMap.put(2,"Two");
        navigableMap.put(4,"Four");
        navigableMap.put(3,"Three");

        System.out.println(navigableMap);

        System.out.println(navigableMap.lowerKey(6));
        System.out.println(navigableMap.higherKey(6));
        System.out.println(navigableMap.ceilingEntry(0));
        System.out.println(navigableMap.descendingMap());

    }
}
