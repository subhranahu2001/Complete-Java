package Collection_New.Set_New;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class SetOverview {

    public static void main(String[] args) {
        //set is a collection that can not contain duplicate elements
        //faster operations
        // map --> HashMap,LinkedHashMap,TreeMap,EnumMap
        // set --> HashSet,LinkedHashSet,TreeSet,EnumSet
        Set<Integer> set = new HashSet<>();
        set.add(1);

        // for thread safety
        Set<String> thread = new ConcurrentSkipListSet<>();

        // unmodifiable set
        Set<Integer> unmodifiable = Set.of(1, 2, 34, 5, 6);
    }
}