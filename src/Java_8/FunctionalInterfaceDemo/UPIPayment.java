package Java_8.FunctionalInterfaceDemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@FunctionalInterface
public interface UPIPayment {

    public String doPayment(String source, String dest);

    default double getScratchCard() {
        return new Random().nextDouble();
    }

    static String datePattern(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date());
    }
}
