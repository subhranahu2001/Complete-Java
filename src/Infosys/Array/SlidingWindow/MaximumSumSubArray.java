package Infosys.Array.SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaximumSumSubArray {

    static StringTokenizer tk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(next(br));
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(next(br));
        }
        System.out.println(Arrays.toString(arr));
        int target = Integer.parseInt(next(br));
        System.out.println(maximumSumSubArray(arr,  target));

    }

    private static int maximumSumSubArray(int[] arr, int k) {

        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int wSum = 0;
        for (int i = 0; i < k; i++) {
            wSum += arr[i];
        }
        int maxSum = wSum;

        for (int i = k; i < n; i++) {
            wSum += arr[i];
            wSum -= arr[i - k];
//            if (wSum > maxSum) {
//                maxSum = wSum;
//            }
            maxSum = Math.max(maxSum, wSum);
        }
        return maxSum;
    }

    static String next(BufferedReader br) throws IOException {

        while (tk == null || !tk.hasMoreTokens()) {
            tk = new StringTokenizer(br.readLine());
        }
        return tk.nextToken();
    }


}
