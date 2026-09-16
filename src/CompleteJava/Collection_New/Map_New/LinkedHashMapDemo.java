package CompleteJava.Collection_New.Map_New;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {

    public static void main(String[] args) {
        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>();

        HashMap<String,Integer> map = new HashMap<>();
        linkedHashMap.put("apple",1);
        linkedHashMap.put("orange",2);
        linkedHashMap.put("banana",3);

        for(Map.Entry<String,Integer> entry : linkedHashMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
