package ExceptionHandling;

public class ConditionCheck {

    public static void main(String[] args) {

        try {
            if (true) {
                if (true){
                    System.out.println(10/0);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
