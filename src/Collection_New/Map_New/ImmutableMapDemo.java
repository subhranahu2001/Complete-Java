package Collection_New.Map_New;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapDemo {

    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);

        Map<String, Integer> map1 = Collections.unmodifiableMap(map);
//        map1.put("three", 3);

        //in of method we can add only 10 key value pairs
        Map<String, Integer> map2 = Map.of("one", 1, "two", 2);

        Map<String, Integer> map3 = Map.ofEntries(Map.entry("one", 1), Map.entry("two", 2));


    }
}
