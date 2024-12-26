package sergeev.alexander.leetcode;

// 2656. Maximum Sum With Exactly K Elements
public class a2656 {

    /*
    You are given a 0-indexed integer array nums and an integer k.
    Your task is to perform the following operation exactly k times in order to maximize your score:
    Select an element m from nums.
    Remove the selected element m from the array.
    Add a new element with a value of m + 1 to the array.
    Increase your score by m.
    Return the maximum score you can achieve after performing the operation exactly k times.
     */

    public static void main(String[] args) {
        int[] nums = {5,5};
        int k = 2;
        System.out.println(maximizeSum(nums, k));
    }

    // BEATS 100%
    public static int maximizeSum(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return (max * k) + (k * (k - 1) / 2);
    }

    // BEATS 80%
    public static int maximizeSum1(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int sum = max;
        int num = 1;
        while (--k > 0) {
            sum += max + num++;
        }
        return sum;
    }
}