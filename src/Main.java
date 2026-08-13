import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{

    public static void main(String[] args) throws InterruptedException {

//        String s = "subhranshu";
//
//        Map<String,Integer> map = new HashMap<>();
////1st way
//        Arrays.stream(s.split(""))
//                .forEach(c -> map.merge(c,1,Integer::sum));
//
//        //2nd way
//        Map<String, Long> collect = Arrays.stream(s.split(""))
//                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
//        System.out.println(collect);
//        System.out.println(map);

        System.out.println(trailingZeroes(30));

    }

    public static  int trailingZeroes(int n) {
        long fact = factorial(n);
        System.out.println(fact);
        int count = 0;
        while(fact > 0) {
            long rem = fact % 10;
            if(rem == 0) {
                count++;
            }else break;
            fact /= 10;
        }
        return count;
    }

    public static  long factorial(int n) {
        if(n == 0 || n == 1) return 1;
        return n * factorial(n-1);
    }
}
