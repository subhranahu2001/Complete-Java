package JavaLangPackage.ObjectCopy;

public class ShallowCopy {

    public static void main(String[] args) throws CloneNotSupportedException {
        Department d = new Department("101","computer science","software");

        Employee e = new Employee(101,"silu",d);

        Employee e2 = e.clone();

        System.out.println(e);
        System.out.println();
        System.out.println(e2);
        e.dept.deptName = "Banking";
        System.out.println(e);
        System.out.println(e2);
    }
}
