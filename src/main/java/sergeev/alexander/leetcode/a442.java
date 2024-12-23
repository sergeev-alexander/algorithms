package sergeev.alexander.leetcode;

import java.util.ArrayList;
import java.util.List;

// 442. Find All Duplicates in an Array
public class a442 {

    /*
    Given an integer array nums of length n where all the integers of nums are in the range [1, n]
    and each integer appears at most twice, return an array of all the integers that appears twice.
    You must write an algorithm that runs in O(n) time and uses only constant auxiliary space,
    excluding the space needed to store the output
     */

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(arr));
    }

    // BEATS 93%
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i] < 0 ? nums[i] * -1 : nums[i];
            if (nums[a - 1] < 0) {
                list.add(a);
            } else nums[a - 1] *= -1;
        }
        return list;
    }

    // BEATS 93%
    public static List<Integer> findDuplicates1(int[] nums) {
        int[] arr = new int[100001];
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (++arr[num] == 2) {
                list.add(num);
            }
        }
        return list;
    }
}