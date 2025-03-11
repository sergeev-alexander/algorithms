package sergeev.alexander.leetcode;

// 1295. Find Numbers with Even Number of Digits
public class a1295 {

    /*
    Given an array nums of integers, return how many of them contain an even number of digits.
     */

    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        System.out.println(findNumbers(nums));
    }

    // BEATS 98%
    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int log = (int) Math.log10(num) + 1;
            if (log % 2 == 0) count++;
        }
        return count;
    }
}
