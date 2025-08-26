package sergeev.alexander.leetcode;

// 2148. Count Elements With Strictly Smaller and Greater Elements
public class a2148 {

    /*
    Given an integer array nums, return the number of elements that have both a strictly smaller and a strictly greater element appear in nums.
     */

    public static void main(String[] args) {
        int[] arr = {-3, 3, 3, 90};
        System.out.println(countElements(arr));
    }

    // BEATS 100%
    public static int countElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int count = 0;

        for (int num : nums) {
            if (num > min && num < max) count++;
        }

        return count;
    }


    // BEATS 12%
    public static int countElements1(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            boolean smaller = false;
            boolean greader = false;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[j] > nums[i]) {
                    greader = true;
                }
                if (nums[j] < nums[i]) {
                    smaller = true;
                }
                if (smaller && greader) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}