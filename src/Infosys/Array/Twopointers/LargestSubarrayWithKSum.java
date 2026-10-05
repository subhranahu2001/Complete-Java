package Infosys.Array.Twopointers;

import Infosys.Array.CommonInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LargestSubarrayWithKSum {


    public static int longestLengthSubArray(int[] arr, int k) {

        if (arr == null || arr.length == 0) {
            return 0;
        }
        long sum = arr[0];
        int length = 0;
        int right = 0;
        int left = 0;
        while (right < arr.length) {
            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }

            if (sum == k) {
                length = Math.max(length, right - left + 1);
            }

            right++;
            if (right < arr.length)
                sum += arr[right];
        }
        return length;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(CommonInput.next(br));
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(CommonInput.next(br));
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(longestLengthSubArray(arr, n));

    }
}
