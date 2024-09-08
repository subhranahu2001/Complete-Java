package JavaLangPackage.StringClass.ImmutableClass;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @param doj mutable
 */
public record Employee(String name, Date doj, List<String> mobile) {

    @Override
    public Date doj() {
        return (Date) doj.clone();
    }

    public List<String> mobile() {
        return new ArrayList<>(this.mobile);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", doj=" + doj +
                ", mobile=" + mobile +
                '}';
    }
}
