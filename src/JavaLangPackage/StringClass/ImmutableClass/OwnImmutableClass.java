package JavaLangPackage.StringClass.ImmutableClass;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
* make your class final.
* Declare all instance variable with private and final.
* say no to setter methods.
* initialize all variable in constructor.
 * Perform cloning of mutable objects while returning from getter methods.
* */
public class OwnImmutableClass {

    public static void main(String[] args) {

        Address address = new Address("blr","57938");
        Employee employee = new Employee("silu",new Date(), Arrays.stream(new String[]{"7967687","8768769"}).toList(),address);
        System.out.println(employee);
        employee.doj().setTime(10);
        System.out.println(employee);
        employee.mobile().add("'7973970");
        employee.address().setCity("pune");

        System.out.println(employee);

        
    }

}
