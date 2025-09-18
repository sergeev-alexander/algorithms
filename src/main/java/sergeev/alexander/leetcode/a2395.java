package sergeev.alexander.leetcode;

import java.util.HashSet;
import java.util.Set;

// 2395. Find Subarrays With Equal Sum
public class a2395 {

    /*
    Given a 0-indexed integer array nums, determine whether there exist two subarrays of length 2 with equal sum.
    Note that the two subarrays must begin at different indices.
    Return true if these subarrays exist, and false otherwise.
    A subarray is a contiguous non-empty sequence of elements within an array.
     */

    public static void main(String[] args) {
        int[] arr = {2,4,2};
        System.out.println(findSubarrays(arr));
    }

    // BEATS 100%
    public static boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0, j = 1; i < nums.length - 1; i++, j++) {
            if (!set.add(nums[i] + nums[j])) return true;
        }

        return false;
    }
}
