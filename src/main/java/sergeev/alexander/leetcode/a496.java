package sergeev.alexander.leetcode;

import java.util.Arrays;

// 496. Next Greater Element I
public class a496 {

    /*
    The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
    You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
    For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2.
    If there is no next greater element, then the answer for this query is -1.
    Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
     */

    public static void main(String[] args) {
        int[] arr1 = {4,1,2};
        int[] arr2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(arr1, arr2)));
    }

    // BEATS 35%
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            int num = -1;

            MARK:
            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {

                    while (++j < nums2.length) {
                        if (nums2[j] > nums1[i]) {
                            num = nums2[j];
                            break MARK;
                        }
                    }
                }
            }

            nums1[i] = num;
        }

        return nums1;
    }
}
