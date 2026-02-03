package OOPS;

class Parent1 {
    static int x = 10;
    static {
        System.out.println("Parent1 static block");
    }
}
class Child1 extends Parent1 {
    static int y = 20;
    static {
        System.out.println("Child1 static block");
    }
}

public class StaticControlFlow {

    public static void main(String[] args) {
        Child1 child1 = new Child1();
    }
}
