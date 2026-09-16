package CompleteJava.Collection_New.List_New;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ListDemo {

    public static void main(String[] args) throws Exception {

        ArrayList<Integer> list = new ArrayList<>(11);
        list.add(1);
        list.add(1);
        list.add(1);list.add(1);list.add(1);
        list.add(1);list.add(1);list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

        System.out.println(list.size());

        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(list);

        System.out.println("ArrayList capacity: " + elementData.length);
        list.add(1);
//
        elementData = (Object[]) field.get(list);
        System.out.println("ArrayList capacity: " + elementData.length);

        list.remove(2);
        list.remove(2);
        list.remove(2);
        list.remove(2);
        list.remove(2);
        list.remove(2);
        list.remove(2);
        list.remove(2);


        elementData = (Object[]) field.get(list);
        System.out.println("ArrayList capacity: " + elementData.length);

        list.trimToSize();
        elementData = (Object[]) field.get(list);
        System.out.println("ArrayList capacity: " + elementData.length);



    }
}
