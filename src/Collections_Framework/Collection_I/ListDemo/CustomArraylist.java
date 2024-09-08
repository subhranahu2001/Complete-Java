package Collections_Framework.Collection_I.ListDemo;

import java.util.ArrayList;

public class CustomArraylist<T> extends ArrayList<T> {

    @Override
    public boolean add(T t) {
        if (this.contains(t)) {
            return false;
        } else return super.add(t);
    }

}
