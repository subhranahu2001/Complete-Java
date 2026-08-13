package Collections_Framework.Collection_I.ComparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student implements Comparable<Student>{
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        if (this.id == o.id) {
            return this.getName().compareTo(o.getName());
        }else if (id > o.id) {
            return 1;
        }else
        return -1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(10, "Thor"));
        students.add(new Student(2, "Bob"));
        students.add(new Student(2, "Aarl"));
        students.add(new Student(10, "Dan"));
        Collections.sort(students);

        System.out.println(students);
    }


}
