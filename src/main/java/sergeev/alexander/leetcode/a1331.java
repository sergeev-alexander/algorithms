package sergeev.alexander.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 1331. Rank Transform of an Array
public class a1331 {

    /*
    Given an array of integers arr, replace each element with its rank.
    The rank represents how large the element is. The rank has the following rules:
    Rank is an integer starting from 1.
    The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
    Rank should be as small as possible.
     */

    public static void main(String[] args) {
        int[] arr = {37,12,28,9,100,56,80,5,12};
        System.out.println(Arrays.toString(arrayRankTransform(arr)));
    }

    // BEATS 65%
    public static int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] copy = new int[n];
        System.arraycopy(arr, 0, copy, 0, n);
        Arrays.sort(copy);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(copy[i])) {
                map.put(copy[i], rank++);
            }
        }
        int[] resultArr = new int[n];
        for (int i = 0; i < n; i++) {
            resultArr[i] = map.get(arr[i]);
        }
        return resultArr;
    }

    // BEATS 52%
    public static int[] arrayRankTransform2(int[] arr) {
        int n = arr.length;
        int[] copy = new int[n];
        System.arraycopy(arr, 0, copy, 0, n);
        Arrays.sort(copy);
        Map<Integer, Integer> map = new HashMap<>();
        int tempVal = Integer.MIN_VALUE;
        int tempPos = 1;
        for (int i = 0; i < n; i++) {
            if (copy[i] != tempVal) {
                map.put(copy[i], tempPos++);
                tempVal = copy[i];
            }
        }
        int[] resultArr = new int[n];
        for (int i = 0; i < n; i++) {
            resultArr[i] = map.get(arr[i]);
        }
        return resultArr;
    }

    // BEATS 25%
    public static int[] arrayRankTransform1(int[] arr) {
        int n = arr.length;
        int[] copy = Arrays.stream(arr)
                .distinct()
                .sorted()
                .toArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < copy.length; i++) {
            map.put(copy[i], i);
        }
        int[] resultArr = new int[n];
        for (int i = 0; i < n; i++) {
            resultArr[i] = map.get(arr[i]) + 1;
        }
        return resultArr;
    }
}
