package JavaLangPackage;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Employee {

    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Employee(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

class Main {
    public static void main(String[] args) {

        Employee e1 = new Employee(1,"silu");
        Employee e2 = new Employee(1,"silu");

        Set<Employee> emp = new HashSet<>();
        emp.add(e1);
        emp.add(e2);
        System.out.println(emp);
    }
}
