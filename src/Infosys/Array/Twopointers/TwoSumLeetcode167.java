package Infosys.Array.Twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class TwoSumLeetcode167 {

    static StringTokenizer tk;


    // brut force approach with O(n^2)
    public static int[] twoSum1 (int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return new int[]{-1,-1};
        }
int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n ; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    // Using 2 pointer approach  and in this array should be sorted
    public static int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length <= 1) {
            return new int[]{-1,-1};
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }

        return nums;
    }

    //using hashmap if array is not sorted
    public static int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return new int[]{-1,-1};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(next(br));
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(next(br));
        }

        System.out.println(Arrays.toString(a));

        int target = Integer.parseInt(next(br));
        System.out.print(Arrays.toString(twoSum(a, target)));
        System.out.print(Arrays.toString(twoSum2(a, target)));
        System.out.print(Arrays.toString(twoSum1(a, target)));

    }

    static String next(BufferedReader br) throws IOException {
        while (tk == null || !tk.hasMoreTokens()) tk = new StringTokenizer(br.readLine());
        return tk.nextToken();
    }
}
