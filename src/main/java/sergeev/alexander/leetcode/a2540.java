package sergeev.alexander.leetcode;

import java.util.HashSet;
import java.util.Set;

// 2540. Minimum Common Value
public class a2540 {

    /*
    Given two integer arrays nums1 and nums2, sorted in non-decreasing order,
    return the minimum integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.
    Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.
     */

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 4};
        int[] num2 = {4, 5, 6};
        System.out.println(getCommon(num1, num2));
    }

    // BEATS 100%
    public static int getCommon(int[] nums1, int[] nums2) {
        if (nums1[nums1.length - 1] < nums2[0] || nums2[nums2.length - 1] < nums1[0]) return -1;
        int point1 = 0;
        int point2 = 0;
        while (point1 < nums1.length && point2 < nums2.length) {
            if (nums1[point1] == nums2[point2]) return nums1[point1];
            else if (nums1[point1] > nums2[point2]) point2++;
            else point1++;
        }
        return -1;
    }

    // BEATS 87%
    public static int getCommon2(int[] nums1, int[] nums2) {
        int point1 = 0;
        int point2 = 0;
        while (point1 < nums1.length && point2 < nums2.length) {
            if (nums1[point1] == nums2[point2]) return nums1[point1];
            if (nums1[point1] > nums2[point2]) {
                    point2++;
            } else {
                    point1++;
            }
        }
        return -1;
    }

    // BEATS 15%
    public static int getCommon1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums1) set.add(n);
        int min = Integer.MAX_VALUE;
        for (int n : nums2)
            if (set.contains(n) && min > n) min = n;
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}