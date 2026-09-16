package CompleteJava.Collections_Framework.Collection_I.SetDemo;

import java.util.HashSet;
import java.util.Set;

public class SetDuplicate {

    public static void main(String[] args) {
        Employee e1 = new Employee(101,"silu");
        Employee e2 = new Employee(102,"thor");
        Employee e3 = new Employee(101,"silu");
        Employee e4 = new Employee(102,"thor");


        Set<Employee> set = new HashSet<>();
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        System.out.println(set);

    }
}
