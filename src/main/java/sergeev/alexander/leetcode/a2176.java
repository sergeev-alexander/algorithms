package sergeev.alexander.leetcode;

// 2176. Count Equal and Divisible Pairs in an Array
public class a2176 {

    /*
    Given a 0-indexed integer array nums of length n and an integer k,
    return the number of pairs (i, j) where 0 <= i < j < n, such that nums[i] == nums[j] and (i * j) is divisible by k.
     */

    public static void main(String[] args) {
        int[] nums = {3,1,2,2,2,1,3};
        int k = 2;
        System.out.println(countPairs(nums, k));
    }

    // BEATS 97%
    public static int countPairs(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) count++;
            }
        }

        return count;
    }
}