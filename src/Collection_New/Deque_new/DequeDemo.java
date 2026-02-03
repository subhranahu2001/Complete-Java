package Collection_New.Deque_new;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {

    public static void main(String[] args) {
        // double-ended queue
        //allows insertion and removal of elements from both ends
        // Versatile than regular queues and stacks because they support all the operations of both

        /*
        * INSERTION METHODS
        * addFirst(E e):Insert the specified element at the front.
        * addLast(E e):Insert the specified element at the end.
        * offerFirst(E e):Insert the specified element at the front if possible.
        * offerLast(E e):Insert the specified element at the end if possible.
        * */

        /*
         * REMOVAL METHODS
         * removeFirst(): Retrieves and removes the first element.
         * removeLast(): Retrieves and removes the last element.
         * pollFirst(): Retrieves and removes the first element, or return null if empty.
         * pollLast(): Retrieves and removes the last element, or return null if empty.         *
         * */

        /*
         * EXAMINATION METHODS
         * getFirst(): Retrieves, but does not remove,the first.        *
         * getLast(): Retrieves, but does not remove,the last.        *
         * peekFirst(): Retrieves, but does not remove,the first or returns null if empty.        *
         * peekLast(): Retrieves, but does not remove,the last or returns null if empty.        *
         * */

        Deque<Integer> deque1 = new ArrayDeque<>();// faster iteration, low memory, no null allowed
        //circular array -> head --> tail
        // no need to shift element
        deque1.addFirst(10);
        deque1.addLast(20);
        deque1.offerFirst(5);
        deque1.offerLast(25);
        //5,10,20,25
        System.out.println("First: " + deque1.peekFirst());//5
        System.out.println("Last: " + deque1.peekLast());//25
        deque1.removeFirst();//5
        deque1.pollLast();//25

        for(int num : deque1) {
            System.out.println(num);
        }

        Deque<Integer> deque2 = new LinkedList<>();// insertion,deletion somewhere in middle

    }
}
