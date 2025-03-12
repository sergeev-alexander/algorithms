package sergeev.alexander.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// 1338. Reduce Array Size to The Half
public class a1338 {

    /*
    You are given an integer array arr.
    You can choose a set of integers and remove all the occurrences of these integers in the array.
    Return the minimum size of the set so that at least half of the integers of the array are removed.
     */

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        System.out.println(minSetSize(arr));
    }

    // BEATS 92%
    public static int minSetSize(int[] arr) {
        int maxNum = Integer.MIN_VALUE;
        for (int num : arr) {
            maxNum = Math.max(maxNum, num);
        }
        int[] freqArr = new int[maxNum + 1];
        for (int num : arr) {
            freqArr[num]++;
        }
        Arrays.sort(freqArr);
        int count = 0;
        int target = arr.length / 2;
        for (int i = freqArr.length - 1; i >= 0; i--) {
            if (freqArr[i] != 0) {
                target -= freqArr[i];
                count++;
                if (target <= 0) return count;
            }
        }
        return -1;
    }

    // BEATS 85%
    public static int minSetSize2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.merge(num, 1, Integer::sum);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int pos = list.size() - 1;
        int target = arr.length / 2;
        int count = 0;
        while (target > 0) {
            target -= list.get(pos--);
            count++;
        }
        return count;
    }

    // BEATS 82%
    public static int minSetSize1(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : arr) {
            map.merge(num, 1, Integer::sum);
        }
        for (int num : map.values()) {
            priorityQueue.offer(num);
        }
        int target = arr.length / 2;
        int count = 0;
        while (target > 0) {
            target -= priorityQueue.poll();
            count++;
        }
        return count;
    }
}
