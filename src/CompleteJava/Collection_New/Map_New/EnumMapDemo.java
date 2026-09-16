package CompleteJava.Collection_New.Map_New;

import java.util.EnumMap;
import java.util.Map;

public class EnumMapDemo {

    public static void main(String[] args) {

        // array of size same as enum
        // no hashing
        // ordinal or index is used
        // faster than hash map
        // memory efficient
        Map<Day,String> map = new EnumMap<>(Day.class);
        map.put(Day.THURSDAY,"Gym");
        map.put(Day.FRIDAY,"Gym");
        map.put(Day.MONDAY,"walk");
        System.out.println(map);
        System.out.println(Day.MONDAY.ordinal());

    }
}

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
