package OOPS;

class Test {
    private static Test test;
    private Test() {}
    public synchronized static Test getInstance() {
        return test == null? test = new Test() : test;
    }
}

public class SingletonClass {

    public static void main(String[] args) {
        Test t1 = Test.getInstance();
        Test t2 = Test.getInstance();
        System.out.println(t1.hashCode() +".."+ t2.hashCode());
    }
}
