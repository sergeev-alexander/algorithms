package sergeev.alexander.leetcode;

// 2154. Keep Multiplying Found Values by Two
public class a2154 {

    /*
    You are given an array of integers nums. You are also given an integer original which is the first number that needs to be searched for in nums.
    You then do the following steps:
    If original is found in nums, multiply it by two (i.e., set original = 2 * original).
    Otherwise, stop the process.
    Repeat this process with the new number as long as you keep finding the number.
    Return the final value of original.
     */

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 1, 12};
        int n = 3;
        System.out.println(findFinalValue(arr, n));
    }

    // BEATS 93%
    public static int findFinalValue(int[] nums, int original) {
        int[] arr = new int[1001];

        for (int num : nums) {
            arr[num]++;
        }

        while (original <= 1000 && arr[original] > 0) {
            arr[original]--;
            original *= 2;
        }

        return original;
    }
}