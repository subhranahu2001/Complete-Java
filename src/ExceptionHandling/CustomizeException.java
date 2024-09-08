package ExceptionHandling;

import java.util.Scanner;

class TooOldException extends RuntimeException {
    public TooOldException(String message) {
        super(message);
    }
}

class TooYoungException extends RuntimeException {
    public TooYoungException(String message) {
        super(message);
    }
}

public class CustomizeException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your age: ");
        int age = sc.nextInt();
        if (age < 18) {
            throw new TooYoungException("You are too young to marriage");
        } else if (age > 18 && age < 50) {
            System.out.println("You eligible to get married");
        } else {
            throw new TooOldException("You are old to marriage");
        }
    }
}
