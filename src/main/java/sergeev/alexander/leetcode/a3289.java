package sergeev.alexander.leetcode;

import java.util.Arrays;

// 3289. The Two Sneaky Numbers of Digitville
public class a3289 {

    /*
    In the town of Digitville, there was a list of numbers called nums containing integers from 0 to n - 1.
    Each number was supposed to appear exactly once in the list, however,
    two mischievous numbers sneaked in an additional time, making the list longer than usual.
    As the town detective, your task is to find these two sneaky numbers.
    Return an array of size two containing the two numbers (in any order), so peace can return to Digitville.
     */

    public static void main(String[] args) {
        int[] nums = {7,1,5,4,3,4,6,0,9,5,8,2};
        System.out.println(Arrays.toString(getSneakyNumbers(nums)));
    }

    // BEATS 100%
    public static int[] getSneakyNumbers(int[] nums) {
        boolean[] arr = new boolean[100];
        int[] resArr = new int[2];
        int pos = 0;

        for (int i : nums) {
            if (arr[i]) {
                resArr[pos++] = i;
            } else {
                arr[i] = true;
            }
        }

        return resArr;
    }
}