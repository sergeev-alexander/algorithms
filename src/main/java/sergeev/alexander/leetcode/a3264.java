package sergeev.alexander.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

// 3264. Final Array State After K Multiplication Operations I
public class a3264 {

    /*
    You are given an integer array nums, an integer k, and an integer multiplier.
    You need to perform k operations on nums. In each operation:
    Find the minimum value x in nums. If there are multiple occurrences of the minimum value, select the one that appears first.
    Replace the selected minimum value x with x * multiplier.
    Return an integer array denoting the final state of nums after performing all k operations.
     */

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 6};
        int k = 5, multiplier = 2;
        System.out.println(Arrays.toString(getFinalState(nums, k, multiplier)));
    }

    // BEATS 100%
    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {

            int minIndex = 0;

            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            nums[minIndex] *= multiplier;
        }
        return nums;
    }

    // BEATS 31%
    public static int[] getFinalState2(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] != b[0]
                ? Integer.compare(a[0], b[0])
                : Integer.compare(a[1], b[1]));

        for (int i = 0; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
        }

        while (k-- > 0) {
            int[] arr = queue.poll();
            nums[arr[1]] = arr[0] *= multiplier;
            queue.offer(arr);
        }

        return nums;
    }

    // BEATS 3%
    public static int[] getFinalState1(int[] nums, int k, int multiplier) {
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], key -> new TreeSet<>()).add(i);
        }

        while (k-- > 0) {
            Map.Entry<Integer, TreeSet<Integer>> entry = map.firstEntry();
            TreeSet<Integer> set = entry.getValue();
            int pos = set.pollFirst();
            int oldKey = entry.getKey();
            int newKey = oldKey * multiplier;
            map.computeIfAbsent(newKey, key -> new TreeSet<>()).add(pos);
            nums[pos] = newKey;

            if (set.isEmpty()) {
                map.remove(entry.getKey());
            }
        }

        return nums;
    }
}