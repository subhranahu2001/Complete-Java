package DSA.Recursion;

public class FibonacciNo {

    public static int solve(int n) {
        if (n <= 1) return 1;
        return solve(n - 1) + solve(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(solve(4));
    }
}
