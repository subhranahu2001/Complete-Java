package New_2026.OPPS_New;

public class Inheritance {
    int x;

    Inheritance(int x) {
      this.x = x;
        System.out.println("Parent "+x);
    }
}

class SubClass extends Inheritance {

    SubClass(int x) {
        super(x);
    }

    public static void main(String[] args) {
        SubClass s = new SubClass(5);
    }
}