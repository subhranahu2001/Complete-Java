package CompleteJava.Collection_New.Map_New;

import java.util.HashMap;

public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<Student,String> map = new HashMap<>();
        map.put(new Student("Alice",1),"Engineer");
        map.put(new Student("Bob",2),"Designer");
        map.put(new Student("Alice",1),"Manager");
        String orDefault = map.getOrDefault(new Student("Alice", 2), "Manager");

        System.out.println(map);
    }

}

record Student(String name,int id) {}
