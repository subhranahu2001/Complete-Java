package Collection_New.Map_New;

import java.util.ArrayList;
import java.util.List;

public class ComparableDemo {

    public static void main(String[] args) {

        List<Person> students = new ArrayList<>();

        students.add(new Person("Jack", 4.7));
        students.add(new Person("Bob", 3.9));
        students.add(new Person("Tony", 6.5));
        students.add(new Person("Bruce", 2.6));

        students.sort(null);
        System.out.println(students);

    }
}

record Person(String name,double cgpa) implements Comparable<Person> {
    @Override
    public int compareTo(Person o) {
        return Double.compare(o.cgpa, this.cgpa);
    }
}
