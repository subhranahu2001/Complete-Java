package JavaLangPackage.ObjectCopy;




class Department implements Cloneable{
    String empId;
    String deptName;
    String designation;

    public Department(String empId, String deptName, String designation) {
        this.empId = empId;
        this.deptName = deptName;
        this.designation = designation;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Department{" +
                "empId='" + empId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}


public class Employee implements Cloneable{

    int id;
    String name;
    Department dept;

    public Employee(int id, String name, Department dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }



    // This Method is used for shallow copy.
    /**@Override
    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }*/
    @Override
    public Employee clone() throws CloneNotSupportedException {
        Employee emp = (Employee) super.clone();
        emp.dept = (Department) dept.clone();
        return emp;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept=" + dept +
                '}';
    }
}
