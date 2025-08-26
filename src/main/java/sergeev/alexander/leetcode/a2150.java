package sergeev.alexander.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 2150. Find All Lonely Numbers in the Array
public class a2150 {

    /*
    You are given an integer array nums. A number x is lonely when it appears only once,
    and no adjacent numbers (i.e. x + 1 and x - 1) appear in the array.
    Return all lonely numbers in nums. You may return the answer in any order.
     */

    public static void main(String[] args) {
        int[] arr = {10,6,5,8};
        System.out.println(findLonely(arr));
        System.out.println();
    }

    // BEATS 97%
    public static List<Integer> findLonely(int[] nums) {
        int[] arr  = new int[(int) Math.pow(10, 6) + 3];

        for (int num : nums) arr[num + 1]++;

        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if (arr[num + 1] == 1 && arr[num] == 0 && arr[num + 2] == 0) list.add(num);
        }

        return list;
    }

    // BEATS 61%
    public static List<Integer> findLonely1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, 1,Integer::sum);
        }

        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if (map.get(num) == 1
                    && !map.containsKey(num + 1)
                    && !map.containsKey(num - 1)) {
                list.add(num);
            }
        }

        return list;
    }
}