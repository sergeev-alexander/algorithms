package sergeev.alexander.leetcode;

// 3701. Compute Alternating Sum
public class a3701 {

    /*
    You are given an integer array nums.
    The alternating sum of nums is the value obtained by adding elements at even indices and subtracting elements at odd indices.
    That is, nums[0] - nums[1] + nums[2] - nums[3]...
    Return an integer denoting the alternating sum of nums.
     */

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7};
        System.out.println(alternatingSum(nums));
    }

    // BEATS 95%
    public static int alternatingSum(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i += 2) {
            sum += nums[i] - nums[i + 1];
        }

        if (n % 2 == 1) {
            sum += nums[n - 1];
        }

        return sum;
    }

    // BEATS 100% (Sometimes 95%)
    public static int alternatingSum4(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int j = 1;

        if (n % 2 == 0) {

            for (int i = 0; i < n; i++) {
                sum += (nums[i++] - nums[j]);
                j += 2;
            }

            return sum;

        } else {

            for (int i = 0; i < n - 1; i++) {
                sum += (nums[i++] - nums[j]);
                j += 2;
            }

            return sum + nums[n - 1];
        }
    }

    // BEATS 95%
    public static int alternatingSum3(int[] nums) {
        int sum = 0;
        int i = 0;

        while (i < nums.length - 1) {
            sum += nums[i] - nums[i + 1];
            i += 2;
        }

        if (i < nums.length) {
            sum += nums[i];
        }

        return sum;
    }

    // BEATS 95%
    public static int alternatingSum2(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) sum += nums[i];
            else sum -= nums[i];
        }

        return sum;
    }

    // BEATS 95%
    public static int alternatingSum1(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += i % 2 == 0 ? nums[i] : -nums[i];
        }

        return sum;
    }
}