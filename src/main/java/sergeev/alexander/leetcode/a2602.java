package sergeev.alexander.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 2602. Minimum Operations to Make All Array Elements Equal
public class a2602 {

    /*
    You are given an array nums consisting of positive integers.
    You are also given an integer array queries of size m. For the ith query,
    you want to make all of the elements of nums equal to queries[i].
    You can perform the following operation on the array any number of times:
    Increase or decrease an element of the array by 1.
    Return an array answer of size m where answer[i] is the minimum number of operations
    to make all elements of nums equal to queries[i].
    Note that after each query the array is reset to its original state.
     */

    public static void main(String[] args) {
        int[] nums = {3, 1, 6, 8};
        int[] queries = {5, 1};
        System.out.println(minOperations(nums, queries));
    }

    // BEATS 63%
    public static List<Long> minOperations3(int[] nums, int[] queries) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] prefixArr = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixArr[i + 1] = nums[i] + prefixArr[i];
        }
        List<Long> result = new ArrayList<>();
        for (int target : queries) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] >= target + 1) {
                    right = mid;
                } else left = mid + 1;
            }
            long posDiff = Math.abs(nums[left] - target);
            long beforePos = (long) target * (left) - prefixArr[left];
            long afterPos = (prefixArr[n] - prefixArr[left + 1]) - (long) target * (n - left - 1);
            result.add(posDiff + beforePos + afterPos);
        }
        return result;
    }

    // BEATS 50%
    public static List<Long> minOperations2(int[] nums, int[] queries) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] prefixArr = new long[n + 1];
        long[] suffixArr = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixArr[i + 1] = nums[i] + prefixArr[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            suffixArr[i] = nums[i] + suffixArr[i + 1];
        }
        List<Long> result = new ArrayList<>();
        for (int target : queries) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] >= target + 1) {
                    right = mid;
                } else left = mid + 1;
            }
            long posElDiff = Math.abs(nums[left] - target);
            long beforePos = (long) target * (left) - prefixArr[left];
            long afterPos = suffixArr[left + 1] - (long) target * (n - left - 1);
            result.add(posElDiff + beforePos + afterPos);
        }
        return result;
    }

    // TLE!
    public static List<Long> minOperations(int[] nums, int[] queries) {
        long[] arr = new long[queries.length];
        for (int num : nums) {
            for (int j = 0; j < queries.length; j++) {
                arr[j] += Math.abs(num - queries[j]);
            }
        }
        return Arrays.stream(arr).boxed().toList();
    }

    // TLE!
    public static List<Long> minOperations1(int[] nums, int[] queries) {
        List<Long> result = new ArrayList<>();
        for (int target : queries) {
            long sum = 0;
            for (int num : nums) {
                sum += Math.abs(target - num);
            }
            result.add(sum);
        }
        return result;
    }
}