package sergeev.alexander.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

// 2570. Merge Two 2D Arrays by Summing Values
public class a2570 {

    /*
    You are given two 2D integer arrays nums1 and nums2.
    nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
    nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
    Each array contains unique ids and is sorted in ascending order by id.
    Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:
    Only ids that appear in at least one of the two arrays should be included in the resulting array.
    Each id should be included only once and its value should be the sum of the values of this id in the two arrays.
    If the id does not exist in one of the two arrays then its value in that array is considered to be 0.
    Return the resulting array. The returned array must be sorted in ascending order by id.
     */

    public static void main(String[] args) {
        int[][] nums1 = {{1,2},{2,3},{4,5}};
        int[][] nums2 = {{1,4},{3,2}};
        for (int[] arr : mergeArrays(nums1, nums2)) {
            System.out.println(Arrays.toString(arr));
        }
    }

    // BEATS 100%
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] result = new int[n1 + n2][];
        int pos1 = 0;
        int pos2 = 0;
        int count = 0;
        while (pos1 < n1 || pos2 < n2) {
            if (pos1 >= n1) {
                result[count] = new int[]{nums2[pos2][0], nums2[pos2][1]};
                pos2++;
                count++;
                continue;
            } else if (pos2 >= n2) {
                result[count] = new int[]{nums1[pos1][0], nums1[pos1][1]};
                pos1++;
                count++;
                continue;
            }
            if (nums1[pos1][0] < nums2[pos2][0]) {
                result[count] = new int[]{nums1[pos1][0], nums1[pos1][1]};
                pos1++;
            } else if (nums1[pos1][0] > nums2[pos2][0]) {
                result[count] = new int[]{nums2[pos2][0], nums2[pos2][1]};
                pos2++;
            } else {
                result[count] = new int[]{nums1[pos1][0], nums1[pos1][1] + nums2[pos2][1]};
                pos1++;
                pos2++;
            }
            count++;
        }
        return Arrays.copyOfRange(result, 0, count);
    }

    // BEATS 32%
    public static int[][] mergeArrays1(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] arr : nums1) {
            map.merge(arr[0], arr[1], Integer::sum);
        }
        for (int[] arr : nums2) {
            map.merge(arr[0], arr[1], Integer::sum);
        }
        int[][] result = new int[map.size()][];
        int pos = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[pos++] = new int[]{entry.getKey(), entry.getValue()};
        }
        return result;
    }
}