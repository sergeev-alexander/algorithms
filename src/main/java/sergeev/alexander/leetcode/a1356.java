package sergeev.alexander.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

// 1356. Sort Integers by The Number of 1 Bits
public class a1356 {

    /*
    You are given an integer array arr.
    Sort the integers in the array in ascending order by the number of 1's in their binary representation
    and in case of two or more integers have the same number of 1's you have to sort them in ascending order.
    Return the array after sorting it.
     */

    public static void main(String[] args) {
        int[] arr = {8,1,2,3,4,5,6,7,0};
        System.out.println(Arrays.toString(sortByBits(arr)));
    }

    // BEATS 99%
    public static int[] sortByBits(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] += Integer.bitCount(arr[i]) * 100000;
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            arr[i] %= 100000;
        }
        return arr;
    }

    // BETAS 18%
    public static int[] sortByBits2(int[] arr) {
        Comparator<Integer> comparator1 = Comparator.comparingInt(Integer::bitCount);
        Comparator<Integer> comparator2 = Comparator.naturalOrder();
        return Arrays.stream(arr)
                .boxed()
                .sorted(comparator1.thenComparing(comparator2))
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // BEATS 39%
    public static int[] sortByBits1(int[] arr) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int num : arr) {
            map.computeIfAbsent(Integer.bitCount(num), v -> new ArrayList<>()).add(num);
        }
        int[] resultArr = new int[arr.length];
        int pos = 0;
        while (!map.isEmpty()) {
            List<Integer> list = map.pollFirstEntry().getValue();
            Collections.sort(list);
            for (int num : list) {
                resultArr[pos++] = num;
            }
        }
        return resultArr;
    }
}