package OOPS;

abstract class  Parent {

    Parent() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

}

public class InstanceFlow {

    public static void main(String[] args) {
        Child c = new Child();
    }
}
