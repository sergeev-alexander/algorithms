package sergeev.alexander;

import java.util.*;

public class Temp2 {

    public static void main(String[] args) {
        int[] nums = {1,2,1,3};
        System.out.println(increasingTriplet(nums));
    }

    // BEATS 94%
    public static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > secondMin) return true;
            if (num <= firstMin) {
                firstMin = num;
            } else {
                secondMin = num;
            }
        }
        return false;
    }

    // BEATS 19%
    public static boolean increasingTriplet1(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int firstMin = nums[0];
        int secondMin = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (nums[i] < firstMin) {
                firstMin = nums[i];
            } else if (nums[i] > firstMin && nums[i] < secondMin) {
                secondMin = nums[i];
            }
            if (nums[i] > secondMin) return true;
        }
        return false;
    }
}
