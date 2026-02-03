package Collection_New.List_New;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);

        list.sort(null);
        System.out.println(list);



//        list.remove(Integer.valueOf(2));
//        System.out.println(list);

//        Object[] array = list.toArray();
//        Integer[] array1 = list.toArray(new Integer[0]);


        List<String> list1 = Arrays.asList("apple", "mango");
        list1.set(1,"banana");
        System.out.println(list1);
//        List<String> list2 = List.of("apple", "mango");
////        list2.add("nk");
//
//
        List<Integer> list3 = List.of(1, 2, 3, 4, 5, 6, 7);
        list.addAll(list3);


    }
}
