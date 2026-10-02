package Infosys.Array.Twopointers;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* Sort 0s, 1s and 2s
Difficulty: MediumAccuracy: 50.58%Submissions: 888K+Points: 4Average Time: 10m
Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order. 

Examples:

Input: arr[] = [0, 1, 2, 0, 1, 2]
Output: [0, 0, 1, 1, 2, 2]
Explanation: 0s, 1s and 2s are segregated into ascending order.
Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
Explanation: 0s, 1s and 2s are segregated into ascending order.
Follow up: Could you come up with a one-pass algorithm using only constant extra space?

Constraints:

1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 2
* 
* */
public class Sort_0_1_2 {
    static StringTokenizer tk;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(next(br));
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(next(br));
        }

        System.out.println(Arrays.toString(a));

        sort(a);
        System.out.println(Arrays.toString(a));


    }

    private static  void swap(int i, int j,int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static void sort(int[] a) {

        if(a.length <= 1) return;

        int low = 0;
        int high = a.length - 1;
        int mid = 0;

        while (mid <= high) {
            if (a[mid] == 0) {
                swap(mid,low,a);
                low++;
                mid++;
            }else if(a[mid] == 1) {
                mid++;
            }else{
                swap(mid,high,a);
                high--;
            }
        }
    }

    static String next(BufferedReader br) throws IOException {
        while (tk == null || !tk.hasMoreTokens()) {
            tk = new StringTokenizer(br.readLine());
        }
        return tk.nextToken();
    }
}
