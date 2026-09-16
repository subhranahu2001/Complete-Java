package CompleteJava.Collection_New.Queue_new;

import java.util.LinkedList;
import java.util.Queue;

public class QueueOverview {

    public static void main(String[] args) {

        Queue<Integer> list = new LinkedList<>();
        list.add(1);
        System.out.println(list.remove());//throw exception
        System.out.println(list.poll());// return null

        System.out.println(list.element());//throw exception

    }
}
