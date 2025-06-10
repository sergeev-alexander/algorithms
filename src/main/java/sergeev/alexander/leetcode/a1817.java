package sergeev.alexander.leetcode;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 1817. Finding the Users Active Minutes
public class a1817 {

    /*
    You are given the logs for users' actions on LeetCode, and an integer k.
    The logs are represented by a 2D integer array logs where each logs[i] = [IDi, timei] indicates that the user with IDi performed an action at the minute timei.
    Multiple users can perform actions simultaneously, and a single user can perform multiple actions in the same minute.
    The user active minutes (UAM) for a given user is defined as the number of unique minutes in which the user performed an action on LeetCode.
    A minute can only be counted once, even if multiple actions occur during it.
    You are to calculate a 1-indexed array answer of size k such that, for each j (1 <= j <= k), answer[j] is the number of users whose UAM equals j.
    Return the array answer as described above.
     */

    public static void main(String[] args) {
        int[][] logs = {{0,5},{1,2},{0,2},{0,5},{1,3}};
        int k = 5;
        System.out.println(Arrays.toString(findingUsersActiveMinutes(logs, k)));
    }

    // BEATS 76%
    public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] result = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] arr : logs) {
            int userId = arr[0];
            int minute = arr[1];

            Set<Integer> minutes = map.get(userId);
            if (minutes == null) {
                minutes = new HashSet<>();
                map.put(userId, minutes);
                minutes.add(minute);
                result[0]++;
            } else if (minutes.add(minute)) {
                int oldSize = minutes.size() - 1;
                if (oldSize <= k) result[oldSize - 1]--;
                if (minutes.size() <= k) {
                    result[minutes.size() - 1]++;
                }
            }
        }

        return result;
    }

    // BEATS 5%
    public static int[] findingUsersActiveMinutes2(int[][] logs, int k) {
        int[] result = new int[k];
        Map<Integer, BitSet> map = new HashMap<>();
        for (int[] arr : logs) {
            map.computeIfAbsent(arr[0], val -> new BitSet()).set(arr[1]);
        }
        for (BitSet bitSet : map.values()) {
            result[bitSet.cardinality() - 1]++;
        }
        return result;
    }

    // BEATS 85%
    public static int[] findingUsersActiveMinutes1(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] arr : logs) {
            map.computeIfAbsent(arr[0], val -> new HashSet<>()).add(arr[1]);
        }
        int[] result = new int[k];
        for (Set<Integer> set : map.values()) {
            result[set.size() - 1]++;
        }
        return result;
    }
}