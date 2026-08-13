package DSA.Recursion;

/*
 * ============================================================================
 *                              R E C U R S I O N
 * ============================================================================
 *
 * 1. WHAT IS RECURSION?
 * ---------------------
 * A function calling itself (directly or indirectly) to solve a problem by
 * breaking it into smaller sub-problems of the SAME type.
 *
 * Big idea  : Solve a small piece yourself, trust the recursive call for the
 *             rest. (This "trust" is called the RECURSIVE LEAP OF FAITH.)
 *
 *
 * 2. THE TWO MANDATORY PARTS
 * --------------------------
 *   a) BASE CASE      -> the smallest input where the answer is known directly.
 *                        Stops the recursion. Without it -> StackOverflowError.
 *   b) RECURSIVE CASE -> the function calls itself on a SMALLER input and
 *                        combines that result with its own work.
 *
 *   Rule: every recursive call must move STRICTLY closer to the base case.
 *
 *   int fact(int n) {
 *       if (n <= 1) return 1;        // base case
 *       return n * fact(n - 1);      // recursive case (n shrinks)
 *   }
 *
 *
 * 3. HOW IT WORKS INTERNALLY (CALL STACK)
 * ---------------------------------------
 * Each call gets its own STACK FRAME holding: parameters, local variables and
 * the return address. Frames are pushed on the way down and popped on the way
 * up (LIFO). JVM default stack ~512KB-1MB => roughly 10,000-20,000 depth.
 *
 * fact(4)
 *   -> 4 * fact(3)
 *        -> 3 * fact(2)
 *             -> 2 * fact(1)
 *                  -> 1            (base case hit, unwinding starts)
 *             <- 2
 *        <- 6
 *   <- 24
 *
 * Stack picture at the deepest point:
 *      | fact(1) |  <- top
 *      | fact(2) |
 *      | fact(3) |
 *      | fact(4) |  <- bottom
 *
 *
 * 4. THE TWO PHASES: BEFORE vs AFTER THE CALL
 * -------------------------------------------
 * Code written BEFORE the recursive call runs on the way DOWN  (top-down).
 * Code written AFTER  the recursive call runs on the way UP    (bottom-up /
 * during backtracking).  Swapping those two lines changes the whole output.
 *
 *   void down(int n) { if (n == 0) return; print(n); down(n - 1); }  // 5 4 3 2 1
 *   void up  (int n) { if (n == 0) return; up(n - 1); print(n); }    // 1 2 3 4 5
 *
 *
 * 5. TYPES OF RECURSION
 * ---------------------
 *  - Direct        : f() calls f().
 *  - Indirect      : f() calls g(), g() calls f() (mutual recursion).
 *  - Linear        : exactly one recursive call per invocation  (factorial).
 *  - Tree/Multiple : more than one call per invocation          (fibonacci).
 *  - Tail          : the recursive call is the LAST action, nothing pending.
 *  - Non-tail (head): work remains after the call returns (n * fact(n-1)).
 *  - Nested        : the argument itself is a recursive call, f(f(n)).
 *
 *  NOTE: Java does NOT perform Tail Call Optimization (TCO). A tail-recursive
 *  method still consumes one stack frame per call in Java, unlike Scala/Kotlin
 *  (tailrec) or functional languages. So deep recursion still overflows.
 *
 *
 * 6. RECURSION vs ITERATION
 * -------------------------
 *  Recursion : shorter/cleaner for tree, graph, divide & conquer, backtracking.
 *              Extra O(depth) memory for stack frames, function-call overhead.
 *  Iteration : faster, constant extra memory, but messy for branching problems.
 *  Any recursion can be converted to iteration using an explicit Stack.
 *
 *
 * 7. COMPLEXITY ANALYSIS
 * ----------------------
 *  Time  = (number of nodes in the recursion tree) x (work per call)
 *  Space = (max depth of the recursion tree)  [+ auxiliary data structures]
 *
 *  Common recurrences (Master Theorem: T(n) = a*T(n/b) + f(n)):
 *      T(n) = T(n-1) + O(1)     -> O(n)          factorial, linear search
 *      T(n) = T(n-1) + O(n)     -> O(n^2)        selection/insertion sort
 *      T(n) = 2T(n-1) + O(1)    -> O(2^n)        subsets, naive fibonacci
 *      T(n) = T(n/2) + O(1)     -> O(log n)      binary search
 *      T(n) = 2T(n/2) + O(1)    -> O(n)          tree traversal
 *      T(n) = 2T(n/2) + O(n)    -> O(n log n)    merge sort
 *      T(n) = n * T(n-1)        -> O(n!)         permutations
 *
 *
 * 8. COMMON PROBLEM PATTERNS
 * --------------------------
 *  - Basic maths      : factorial, power, GCD, sum of digits, reverse number.
 *  - Array/String     : sum, max, reverse, palindrome, linear/binary search.
 *  - Divide & Conquer : merge sort, quick sort, binary search.
 *  - Subsequences     : include/exclude (pick / not-pick) -> 2^n choices.
 *  - Permutations     : swap-based or used[] + backtracking.
 *  - Backtracking     : N-Queens, Sudoku, rat in a maze, word search.
 *                       Pattern -> choose  ->  explore  ->  UN-choose.
 *  - Memoization (DP) : cache overlapping sub-problems, top-down DP.
 *  - Tree/Graph       : traversals, height, DFS, flood fill.
 *
 *
 * 9. HOW TO WRITE A RECURSIVE SOLUTION (RECIPE)
 * ---------------------------------------------
 *   1. Define the function meaning in ONE English sentence.
 *      "f(n) returns the sum of the first n natural numbers."
 *   2. Find the base case (smallest valid input).
 *   3. Assume f(smaller) is already correct (leap of faith).
 *   4. Combine that result to build the answer for the current input.
 *   5. Verify progress toward the base case, then dry-run a tiny input.
 *
 *
 * 10. COMMON MISTAKES
 * -------------------
 *   - Missing / unreachable base case            -> StackOverflowError.
 *   - Input not shrinking (f(n) calling f(n)).
 *   - Forgetting to RETURN the recursive result.
 *   - Sharing mutable state without undoing it in backtracking.
 *   - Passing the whole array/list copy per call  -> hidden O(n) per level.
 *   - Recomputing overlapping sub-problems        -> use memoization.
 *
 * ============================================================================
 */
public class Concept {

    /* ---------- 1. Linear recursion : n! ---------- Time O(n) | Space O(n) */
    static int factorial(int n) {
        if (n <= 1) return 1;               // base case
        return n * factorial(n - 1);        // non-tail (work pending after call)
    }

    /* ---------- 2. Tail recursion : n! with accumulator ---------- */
    static int factorialTail(int n, int acc) {
        if (n <= 1) return acc;
        return factorialTail(n - 1, n * acc);   // nothing pending after the call
    }

    /* ---------- 3. Print on the way DOWN vs on the way UP ---------- */
    static void printDown(int n) {              // 5 4 3 2 1
        if (n == 0) return;
        System.out.print(n + " ");
        printDown(n - 1);
    }

    static void printUp(int n) {                // 1 2 3 4 5
        if (n == 0) return;
        printUp(n - 1);
        System.out.print(n + " ");
    }

    /* ---------- 4. Tree recursion : fibonacci ---------- Time O(2^n) ---- */
    static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);         // two calls -> recursion TREE
    }

    /* ---------- 5. Memoized fibonacci ---------- Time O(n) | Space O(n) -- */
    static int fibMemo(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != 0) return dp[n];           // overlapping sub-problem reused
        return dp[n] = fibMemo(n - 1, dp) + fibMemo(n - 2, dp);
    }

    /* ---------- 6. Divide & conquer : fast power ---------- O(log n) ----- */
    static long power(long base, int exp) {
        if (exp == 0) return 1;
        long half = power(base, exp / 2);
        return (exp % 2 == 0) ? half * half : half * half * base;
    }

    /* ---------- 7. Euclid's GCD ---------- O(log(min(a,b))) -------------- */
    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    /* ---------- 8. Two-pointer recursion : palindrome ---------- O(n) ---- */
    static boolean isPalindrome(String s, int i, int j) {
        if (i >= j) return true;                            // met/crossed
        if (s.charAt(i) != s.charAt(j)) return false;
        return isPalindrome(s, i + 1, j - 1);
    }

    /* ---------- 9. Array recursion : sum & reverse ---------- O(n) ------- */
    static int arraySum(int[] a, int i) {
        if (i == a.length) return 0;
        return a[i] + arraySum(a, i + 1);
    }

    static void reverse(int[] a, int i, int j) {
        if (i >= j) return;
        int t = a[i]; a[i] = a[j]; a[j] = t;
        reverse(a, i + 1, j - 1);
    }

    /* ---------- 10. Binary search ---------- O(log n) -------------------- */
    static int binarySearch(int[] a, int low, int high, int key) {
        if (low > high) return -1;                          // base: not found
        int mid = low + (high - low) / 2;                   // avoids overflow
        if (a[mid] == key) return mid;
        return (a[mid] > key) ? binarySearch(a, low, mid - 1, key)
                              : binarySearch(a, mid + 1, high, key);
    }

    /* ---------- 11. Pick / Not-pick : print all subsequences ------------- */
    /*  Time O(2^n * n) | Space O(n) — the classic include/exclude template  */
    static void subsequences(int[] a, int i, java.util.List<Integer> cur) {
        if (i == a.length) {                                // one full choice made
            System.out.println(cur);
            return;
        }
        cur.add(a[i]);                                      // CHOOSE
        subsequences(a, i + 1, cur);                        // EXPLORE
        cur.remove(cur.size() - 1);                         // UN-CHOOSE (backtrack)
        subsequences(a, i + 1, cur);                        // explore without a[i]
    }

    /* ---------- 12. Backtracking : permutations of a string -------------- */
    /*  Time O(n! * n) | Space O(n)                                          */
    static void permutations(char[] c, int idx) {
        if (idx == c.length) {
            System.out.println(new String(c));
            return;
        }
        for (int k = idx; k < c.length; k++) {
            swap(c, idx, k);                // choose
            permutations(c, idx + 1);       // explore
            swap(c, idx, k);                // un-choose : restore original state
        }
    }

    private static void swap(char[] c, int i, int j) {
        char t = c[i]; c[i] = c[j]; c[j] = t;
    }

    /* ---------- 13. Indirect (mutual) recursion ------------------------- */
    static boolean isEven(int n) { return (n == 0) ? true  : isOdd(n - 1); }
    static boolean isOdd(int n)  { return (n == 0) ? false : isEven(n - 1); }


    public static void main(String[] args) {
        System.out.println("factorial(5)      = " + factorial(5));          // 120
        System.out.println("factorialTail(5)  = " + factorialTail(5, 1));   // 120

        System.out.print("printDown(5)      : "); printDown(5); System.out.println();
        System.out.print("printUp(5)        : "); printUp(5);   System.out.println();

        System.out.println("fib(10)           = " + fib(10));               // 55
        System.out.println("fibMemo(10)       = " + fibMemo(10, new int[11]));
        System.out.println("power(2,10)       = " + power(2, 10));          // 1024
        System.out.println("gcd(48,18)        = " + gcd(48, 18));           // 6
        System.out.println("isPalindrome(madam)= "
                + isPalindrome("madam", 0, "madam".length() - 1));          // true

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("arraySum          = " + arraySum(arr, 0));      // 15
        reverse(arr, 0, arr.length - 1);
        System.out.println("reversed          = " + java.util.Arrays.toString(arr));

        int[] sorted = {10, 20, 30, 40, 50};
        System.out.println("binarySearch(40)  = " + binarySearch(sorted, 0, sorted.length - 1, 40));

        System.out.println("--- subsequences of [1,2,3] ---");
        subsequences(new int[]{1, 2, 3}, 0, new java.util.ArrayList<>());

        System.out.println("--- permutations of \"abc\" ---");
        permutations("abc".toCharArray(), 0);

        System.out.println("isEven(10)        = " + isEven(10));            // true
    }
}
