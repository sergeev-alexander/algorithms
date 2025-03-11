package sergeev.alexander.leetcode;

// 1287. Element Appearing More Than 25% In Sorted Array
public class a1287 {

    /*
    Given an integer array sorted in non-decreasing order,
    there is exactly one integer in the array that occurs more than 25% of the time, return that integer.
     */

    public static void main(String[] args) {
        int[] arr = {1,2,2,6,6,6,6,7,10};
        System.out.println(findSpecialInteger(arr));
    }

    // BEATS 100%
    public static int findSpecialInteger(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[i + (n / 4)]) {
                return arr[i];
            }
        }
        return -1;
    }

    // BEATS 30%
    public static int findSpecialInteger1(int[] arr) {
        double target = arr.length / 4.0;
        int[] nums = new int[10_001];
        for (int num : arr) {
            if (++nums[num] > target) return num;
        }
        return -1;
    }
}