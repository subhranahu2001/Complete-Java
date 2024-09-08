package JavaLangPackage.ObjectClass;

class Student {
    private String name;
    private int age;
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            System.out.println("From here");
            return true;
        }
        if (obj instanceof Student) {
            Student student = (Student) obj;
            return this.name.equals(student.name) && this.age == student.age;
        }
        return false;
    }
}

public class EqualMethodOverriding {


    public static void main(String[] args) {
        Student s1 = new Student("silu",23);
        Student s2 = new Student("tony",30);
        Student s3 = new Student("silu",23);
        Student s4 = s3;
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s3.equals(s4));
    }
}
