package Collection_New.List_New;

import java.util.LinkedList;
import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();//Last in First Out
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        Integer peek = stack.peek();//5
        System.out.println(peek);


        LinkedList<Integer> stack2 = new LinkedList<>();
        stack2.addLast(1);
        stack2.addLast(2);
        stack2.addLast(3);
        stack2.addLast(4);
        System.out.println(stack2);
        stack2.removeLast();
        System.out.println(stack2);

    }
}
