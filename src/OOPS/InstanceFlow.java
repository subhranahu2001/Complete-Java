package OOPS;

abstract class  Parent {

    Parent() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    Child() {
        System.out.println("Child");
    }
}

public class InstanceFlow {

    public static void main(String[] args) {
        Child c = new Child();
    }
}
