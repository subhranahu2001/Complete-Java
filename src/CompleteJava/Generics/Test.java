package CompleteJava.Generics;

enum Operations {
    ADD, SUBTRACT, MULTIPLY, DIVIDE;

    public <T extends Number> double apply(T a, T b) {
        return switch (this) {
            case ADD -> a.doubleValue() + b.doubleValue();
            case SUBTRACT -> a.doubleValue() - b.doubleValue();
            case MULTIPLY -> a.doubleValue() * b.doubleValue();
            case DIVIDE -> a.doubleValue() / b.doubleValue(); // assumes b != 0
        };
    }
}


public class Test {

    public static void main(String[] args) {
        Operations op = Operations.ADD;
        double result = op.apply(10, 20);
        System.out.println(result);
    }
}
