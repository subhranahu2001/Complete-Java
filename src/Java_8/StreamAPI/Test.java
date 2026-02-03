package Java_8.StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        List<User> users =Stream.of(
                new User("silu","5582564", Arrays.asList("silu@gmail.com","abc@gmailcom")),
                new User("thor","146545", Arrays.asList("thor@gmail.com","def@gmailcom")),
                new User("tony","15645645", Arrays.asList("tony@gmail.com","ghi@gmailcom")),
                new User("bruce","2242242", Arrays.asList("bruce@gmail.com","jkl@gmailcom"))
                ).toList();


        List<String> list = users.stream()
                .flatMap(user -> user.getEmail().stream())
                .toList();
        System.out.println(list);

    }
}
