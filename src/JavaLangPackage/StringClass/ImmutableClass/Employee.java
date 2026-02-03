package JavaLangPackage.StringClass.ImmutableClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @param doj mutable
 */
public record Employee(String name, Date doj, List<String> mobile,Address address) {

    @Override
    public Date doj() {
        return (Date) doj.clone();
    }

    @Override
    public List<String> mobile() {
//        return Collections.unmodifiableList(mobile);
        return new ArrayList<>(this.mobile);
    }
    @Override
    public Address address() {
        return new Address(address.getCity(), address.getZip());
    }

}
