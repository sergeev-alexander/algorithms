package sergeev.alexander.leetcode;

import java.util.ArrayList;
import java.util.List;

// 46. Permutations
public class a46 {

    /*
    Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
     */

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(permute(arr));
    }

    // BEATS 100%
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(nums, 0, result);
        return result;
    }

    public static void generatePermutations(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length - 1) {
            List<Integer> list = new ArrayList<>();

            for (int num : nums) {
                list.add(num);
            }

            result.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            generatePermutations(nums, start + 1, result);
            swap(nums, start, i);
        }
    }

    public static void swap(int[] nums, int start, int i) {
        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;
    }
}