package Infosys.Array.Twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RemoveDuplicatesLtCo26 {

    public static int removeDuplicates(int[] nums) {
        int count =0;
        for(int n:nums){
            if (count == 0 || nums[count-1] != nums[n]){
                nums[count] = nums[n];
                count++;
            }
        }
        return count;
    }


    static StringTokenizer tk;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(next(br));
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(next(br));
        }

        System.out.println(Arrays.toString(a));

        System.out.println(removeDuplicates(a));


    }

    static String next(BufferedReader br) throws IOException {
        while (tk == null || !tk.hasMoreTokens()) {
            tk = new StringTokenizer(br.readLine());
        }
        return tk.nextToken();
    }
}
