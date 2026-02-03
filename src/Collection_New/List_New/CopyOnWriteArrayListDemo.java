package Collection_New.List_New;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        list.add("Milk");
        list.add("Eggs");
        list.add("Bread");
        System.out.println(list);

        for(String item : list) {
            System.out.println(item);
            if(item.equals("Eggs")) {
                list.add("Butter");
                System.out.println("Butter is added to the list");
            }
        }

        System.out.println(list);


    }
}
