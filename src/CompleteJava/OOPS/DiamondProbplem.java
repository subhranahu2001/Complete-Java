package CompleteJava.OOPS;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class DiamondProbplem {


    @important(value = false)
    public void m1() {

    }

    public static void main(String[] args) {
        
    }


}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface important {
    boolean value() default true;
}
