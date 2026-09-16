package CompleteJava.Collection_New.List_New;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

record Student(String name,double cgpa) implements Comparable<Student> {
    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name());
    }
}

public class ComparatorDemo {

    class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    static class StringLengthComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
//            return o1.compareTo(o2);// this is for alphabetical order
        }
    }


    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 3.5));
        students.add(new Student("Jack", 3.7));
        students.add(new Student("Bob", 3.5));
        students.add(new Student("Tony", 3.9));

        Comparator<Student> studentComparator = Comparator.comparingDouble(Student::cgpa).reversed().thenComparing(Student::name);

//        students.sort((s1,s2) -> {
//            if (s1.cgpa() - s2.cgpa() > 0) {
//                return -1;
//            } else if (s1.cgpa() - s2.cgpa() < 0) {
//                return 1;
//            }else return s1.name().compareTo(s2.name());
//        });
        students.sort(studentComparator);
        System.out.println(students);





//        ArrayList<Integer> list = new ArrayList<>();
//        list.addAll(List.of(1,5,2,7,9,0));
//        list.sort(new ComparatorDemo().new MyComparator());
//
//        System.out.println(list);
//
//        List<String> list2 = new ArrayList<>();
//        list2.add("bked");
//        list2.add("ayeg");
//        list2.sort((o1, o2) -> o2.length() - o1.length());
//        System.out.println(list2);

    }
}
