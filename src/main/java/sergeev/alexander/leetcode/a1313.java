package sergeev.alexander.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1313. Decompress Run-Length Encoded List
public class a1313 {

    /*
    We are given a list nums of integers representing a list compressed with run-length encoding.
    Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]] (with i >= 0).
    For each such pair, there are freq elements with value val concatenated in a sublist.
    Concatenate all the sublists from left to right to generate the decompressed list.
    Return the decompressed list.
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(decompressRLElist(nums)));

    }

    // BEATS 100%
    public static int[] decompressRLElist(int[] nums) {
        int n = nums.length;
        int size = 0;

        for (int i = 0; i < n; i += 2) {
            size += nums[i];
        }

        int[] res = new int[size];
        int pos = 0;

        for (int i = 1; i < n; i += 2) {
            Arrays.fill(res, pos, pos + nums[i - 1], nums[i]);
            pos += nums[i - 1];
        }

        return res;
    }

    // BEATS 62%
    public static int[] decompressRLElist4(int[] nums) {
        int[] dest = new int[5000];
        int destPos = 0;

        for (int i = 1; i < nums.length; i += 2) {

            for (int j = 0; j < nums[i - 1]; j++) {
                dest[destPos++] = nums[i];
            }
        }

        int[] res = new int[destPos];
        System.arraycopy(dest, 0, res, 0, destPos);

        return res;
    }

    // BEATS 64%
    public static int[] decompressRLElist3(int[] nums) {
        int[] dest = new int[5000];
        int destPos = 0;

        for (int i = 1; i < nums.length; i += 2) {
            int[] curr = new int[nums[i - 1]];

            for (int j = 0; j < nums[i - 1]; j++) {
                curr[j] = nums[i];
            }

            System.arraycopy(curr, 0, dest, destPos, curr.length);
            destPos += curr.length;
        }

        int[] res = new int[destPos];
        System.arraycopy(dest, 0, res, 0, destPos);

        return res;
    }

    // BEATS 53%
    public static int[] decompressRLElist2(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i - 1]; j++) {
                list.add(nums[i]);
            }
        }

        int[] arr = new int[list.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    // BEATS 86%
    public static int[] decompressRLElist1(int[] nums) {
        int n = nums.length;
        int size = 0;

        for (int i = 0; i < n; i += 2) {
            size += nums[i];
        }

        int[] res = new int[size];
        int pos = 0;

        for (int i = 1; i < n; i += 2) {
            for (int j = 0; j < nums[i - 1]; j++) {
                res[pos++] = nums[i];
            }
        }

        return res;
    }
}