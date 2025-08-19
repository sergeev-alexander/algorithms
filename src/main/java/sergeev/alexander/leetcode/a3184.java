package sergeev.alexander.leetcode;

import java.util.HashMap;
import java.util.Map;

// 3184. Count Pairs That Form a Complete Day I
public class a3184 {

    /*
    Given an integer array hours representing times in hours,
    return an integer denoting the number of pairs i, j where i < j and hours[i] + hours[j] forms a complete day.
    A complete day is defined as a time duration that is an exact multiple of 24 hours.
    For example, 1 day is 24 hours, 2 days is 48 hours, 3 days is 72 hours, and so on.
     */

    public static void main(String[] args) {
        int[] arr = {72,48,24,3};
        System.out.println(countCompleteDayPairs(arr));
    }

    // BEATS 94%
    public static int countCompleteDayPairs(int[] hours) {
        int[] arr = new int[24];
        int count = 0;

        for (int num : hours) {
            int remainder = num % 24;
            int target = (remainder == 0) ? 0 : 24 - remainder;
            count += arr[target];
            arr[remainder]++;
        }

        return count;
    }

    // BEATS 16%
    public static int countCompleteDayPairs2(int[] hours) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : hours) {
            int remainder = num % 24;
            int target = (remainder == 0) ? 0 : 24 - remainder;
            count += map.getOrDefault(target, 0);
            map.merge(remainder, 1, Integer::sum);
        }

        return count;
    }

    // BEATS 94%
    public static int countCompleteDayPairs1(int[] hours) {
        int n = hours.length;
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) count++;
            }
        }

        return count;
    }
}