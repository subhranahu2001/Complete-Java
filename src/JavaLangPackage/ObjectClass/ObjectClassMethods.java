package JavaLangPackage.ObjectClass;

import java.lang.reflect.Method;

public class ObjectClassMethods {

    public static void main(String[] args) {
        Object obj = new Object();
        Method[] methods = obj.getClass().getMethods();
        int count  = 0;
        for (Method method : methods) {
            System.out.println(method.getName());
            count++;
        }
        System.out.println(count);
    }
}
