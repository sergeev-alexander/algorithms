package sergeev.alexander.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1481. Least Number of Unique Integers after K Removals
public class a1481 {

    /*
    Given an array of integers arr and an integer k.
    Find the least number of unique integers after removing exactly k elements.
     */

    public static void main(String[] args) {
        int[] arr = {5,5,4};
        int k = 1;
        System.out.println(findLeastNumOfUniqueInts(arr, k));
    }

    // BEATS 92%
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (arr.length == k) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.merge(num, 1, Integer::sum);
        }
        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());
        for (int i = list.size() - 1; i >= 0; i--) {
            int num = list.get(i);
            if (num > k) {
                return list.size();
            } else {
                k -= list.remove(i);
            }
        }
        return -1;
    }
}