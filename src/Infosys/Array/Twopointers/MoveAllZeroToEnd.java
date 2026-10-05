package Infosys.Array.Twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MoveAllZeroToEnd {

    static StringTokenizer tk;

    public static void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {

            if (nums[i] != 0 && nums[j] != 0) {
                j++;
            } else if (nums[i] == 0 && nums[j] == 0) {

            }else {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
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
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));


    }

    static String next(BufferedReader br) throws IOException {

        while (tk == null || !tk.hasMoreTokens()) {
            tk = new StringTokenizer(br.readLine());
        }
        return tk.nextToken();
    }
}
