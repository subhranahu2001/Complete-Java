import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{

    public static void main(String[] args) throws InterruptedException {

        String s = "subhranshu";

        Map<String,Integer> map = new HashMap<>();
//1st way
        Arrays.stream(s.split(""))
                .forEach(c -> map.merge(c,1,Integer::sum));

        //2nd way
        Map<String, Long> collect = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(collect);
        System.out.println(map);

    }
}
