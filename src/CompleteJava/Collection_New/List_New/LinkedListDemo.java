package CompleteJava.Collection_New.List_New;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListDemo {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.addFirst(0);
        list.addLast(4);
        System.out.println(list);

        LinkedList<String> animal =
                new LinkedList<>(Arrays.asList("cat","elephant","Lion"));

        LinkedList<String> animal2 =
                new LinkedList<>(Arrays.asList("cat","elephant","Dog"));
        animal.removeAll(animal2);
        System.out.println(animal);

    }
}
