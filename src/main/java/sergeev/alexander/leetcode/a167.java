package sergeev.alexander.leetcode;

import java.util.Arrays;

// 167. Two Sum II - Input Array Is Sorted
public class a167 {

    /*
    Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
    find two numbers such that they add up to a specific target number.
    Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
    Return the indices of the two numbers, index1 and index2,
    added by one as an integer array [index1, index2] of length 2.
     */

    public static void main(String[] args) {

        int[] n = {2, 3, 4, 5, 6, 7, 8, 9};
        int target = 11;

        System.out.println(Arrays.toString(twoSum(n, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) return new int[]{left + 1, right + 1};
            if (sum < target) left++;
            else right--;
        }
        return null;
    }

    public static int[] twoSum_VERY_SLOW(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
            }
        }
        return null;
    }
}
