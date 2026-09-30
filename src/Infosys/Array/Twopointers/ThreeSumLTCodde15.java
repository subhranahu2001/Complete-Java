package Infosys.Array.Twopointers;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
Example 1:

Input: nums = [-1,0,1,2,-1,-4]  after sort -4,-1,-1,0,1,2
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
* */
public class ThreeSumLTCodde15 {

    static StringTokenizer tk;

    // Brut force approach
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) return list;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                for (int k = j + 1; k < n; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }

            }
        }
        return list;
    }

    //optimal using Hashing
    public static List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        if (nums.length < 3) return new ArrayList<>(set);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            Set<Integer> hash = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i] + nums[j]);
                if (hash.contains(third)) {
                    set.add(Arrays.asList(nums[i], nums[j], third));
                }
                hash.add(nums[j]);
            }
        }
        return new ArrayList<>(set);
    }

    //Optimal solution using 2 pointer
    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(next(br));
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(next(br));

        System.out.println(Arrays.toString(a));

        System.out.println(threeSum(a));

    }

    static String next(BufferedReader br) throws IOException {
        while (tk == null || !tk.hasMoreTokens()) {
            tk = new StringTokenizer(br.readLine());
        }
        return tk.nextToken();
    }

}
