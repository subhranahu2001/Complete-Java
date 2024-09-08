package Collections_Framework.Collection_I.ListDemo;

import java.util.*;

public class ArraylistDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        for (int i = 64; i < 75; i++) {
            list.add(String.valueOf((char) i));
        }

//        ListIterator<String> iterator = list.listIterator();
//        while(iterator.hasNext()) {
//            System.out.print(iterator.next());
//        }
        System.out.println();
        for(String l : list) {
            System.out.print(l);
        }
        System.out.println(format(list));

    }

    static List<String> format(List<String> list) {

//        Collections.reverse(list);
        Collections.sort(list,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        return list;

    }


}
