package sergeev.alexander.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 1207. Unique Number of Occurrences
public class a1207 {

    /*
    Given an array of integers arr,
    return true if the number of occurrences of each value in the array is unique or false otherwise.
     */

    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.println(uniqueOccurrences(arr));
    }

    // BEATS 98%
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.merge(num, 1, Integer::sum);
        }
        Set<Integer> set = new HashSet<>();
        for (int num : map.values()) {
            if (!set.add(num)) return false;
        }
        return true;
    }
}
