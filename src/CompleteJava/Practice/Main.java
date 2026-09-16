package CompleteJava.Practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

record Student(String name,double cgpa)implements Comparable<Student>{

    @Override
    public int compareTo(Student o) {
        String name = o.name();
        return this.name.compareTo(name);
    }
}

public class Main {

    static Comparator<Student> comparator = (s1,s2) -> {
        if (s1.cgpa() < s2.cgpa()) return -1;
        else if (s1.cgpa() > s2.cgpa()) return 1;
        else return s2.name().compareTo(s1.name());

    };

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 1.5));
        students.add(new Student("Jane", 2.5));
        students.add(new Student("Jack", 3.5));
        students.add(new Student("Bob", 2.5));
        students.add(new Student("Mary", 5.5));

        students.sort(null);
        System.out.println(students);

    }
}

