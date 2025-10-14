package sergeev.alexander.leetcode;

import java.util.HashMap;
import java.util.Map;

// 1399. Count Largest Group
public class a1399 {

    /*
    You are given an integer n.
    We need to group the numbers from 1 to n according to the sum of its digits.
    For example, the numbers 14 and 5 belong to the same group, whereas 13 and 3 belong to different groups.
    Return the number of groups that have the largest size, i.e. the maximum number of elements.
     */

    public static void main(String[] args) {
        int n = 13;
        System.out.println(countLargestGroup(n));
    }

    // BEATS 79%
    public static int countLargestGroup(int n) {
        int[] arr = new int[(int) Math.pow(10, 4) + 1];
        int max = 0;

        for (int i = 1; i <= n; i++) {
            int res = 0;
            int num = i;

            while (num > 0) {
                res += num % 10;
                num /= 10;
            }

            max = Math.max(max, ++arr[res]);
        }

        int count = 0;

        for (int num : arr) {
            if (num == max) count++;
        }

        return count;
    }

    // BEATS 59%
    public static int countLargestGroup1(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 1; i <= n; i++) {
            int res = 0;
            int num = i;

            while (num > 0) {
                res += num % 10;
                num /= 10;
            }

            max = Math.max(max, map.merge(res, 1, Integer::sum));

        }

        int count = 0;

        for (int num : map.values()) {
            if (num == max) count++;
        }

        return count;
    }
}