package Infosys.Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MoveElementsKPlaces {

    static StringTokenizer tk;


    public static void rotateArray(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }
        for (int i = k; i < arr.length; i++) {
            arr[i-k] = arr[i];
        }
        for (int i = arr.length - k; i < arr.length; i++) {
            arr[i] = temp[i - (arr.length- k)];
        }

    }


    public static void optimalRotate(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return;
        }
        k = k % arr.length;
        reverse(arr, 0, k-1);
        reverse(arr, k, arr.length-1);
        reverse(arr , 0, arr.length - 1);
    }

    public static void reverse(int[] arr, int start, int end) {

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(next(br));
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(next(br));
        }
        System.out.println(Arrays.toString(arr));
        int  k = Integer.parseInt(next(br));

        optimalRotate(arr, k);
        System.out.println(Arrays.toString(arr));

    }

    static String next(BufferedReader br) throws IOException {

        while (tk == null || !tk.hasMoreTokens()) {
            tk = new StringTokenizer(br.readLine());
        }
        return tk.nextToken();
    }
}
