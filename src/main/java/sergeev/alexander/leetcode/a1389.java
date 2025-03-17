package sergeev.alexander.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 1389. Create Target Array in the Given Order
public class a1389 {

    /*
    Given two arrays of integers nums and index. Your task is to create target array under the following rules:
    Initially target array is empty.
    From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
    Repeat the previous step until there are no elements to read in nums and index.
    Return the target array.
    It is guaranteed that the insertion operations will be valid.
     */

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4};
        int[] index = {0, 1, 2, 2, 1};
        System.out.println(Arrays.toString(createTargetArray(nums, index)));
    }

    // BEATS 100%
    public static int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(index[i], nums[i]);
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    // BEATS 23%
    public static int[] createTargetArray1(int[] nums, int[] index) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int pos = index[i];
            int num = nums[i];
            while (pos < n) {
                int temp = result[pos];
                result[pos++] = num;
                num = temp;
            }
        }
        return result;
    }
}