package sergeev.alexander.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// 1345. Jump Game IV
public class a1345 {

    /*
    Given an array of integers arr, you are initially positioned at the first index of the array.
    In one step you can jump from index i to index:
    i + 1 where: i + 1 < arr.length.
    i - 1 where: i - 1 >= 0.
    j where: arr[i] == arr[j] and i != j.
    Return the minimum number of steps to reach the last index of the array.
    Notice that you can not jump outside of the array at any time.
     */

    public static void main(String[] args) {
        int[] arr = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        System.out.println(minJumps(arr));
    }

    // BEATS 5%
    public static int minJumps1(int[] arr) {
        int n = arr.length;
        List<List<Integer>> graph = new ArrayList<>();

        for (int j = 0; j < 2 * n - 1; ++j) {
            graph.add(new ArrayList<>());
        }

        for (int j = 0; j < 2 * n - 2; ++j) {
            graph.get(j).add(j + 1);
            graph.get(j + 1).add(j);
        }

        Map<Integer, Integer> continents = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int c = arr[i];
            if (!continents.containsKey(c)) {
                continents.put(c, graph.size());
                graph.add(new ArrayList<>());
            }
            graph.get(i * 2).add(continents.get(c));
            graph.get(continents.get(c)).add(i * 2);
        }

        int[] distance = new int[graph.size()];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int j = queue.remove();
            if (j == 2 * n - 2) {
                break;
            }
            for (int k : graph.get(j)) {
                if (distance[k] == 0) {
                    distance[k] = distance[j] + 1;
                    queue.add(k);
                }
            }
        }
        return distance[2 * n - 2] / 2;
    }

    // TLE
    public static int minJumps(int[] arr) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || i == arr.length - 1) {
                list.add(arr[i]);
            } else {
                if (arr[i] != arr[i + 1]) {
                    list.add(arr[i]);
                }
            }
        }

        if (list.size() == 1) {
            return 0;
        }
        if (list.size() == 2) {
            return 1;
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            Set<Integer> set = new HashSet<>();
            if (i == 0) {
                set.add(i + 1);
            } else if (i == list.size() - 1) {
                set.add(i - 1);
            } else {
                set.add(i - 1);
                set.add(i + 1);
            }
            for (int j = 0; j < list.size(); j++) {
                if (j != i && list.get(i).equals(list.get(j))) {
                    set.add(j);
                }
            }
            map.put(i, set);
        }

        Map<Integer, Integer> distances = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        distances.put(0, 0);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            if (current == list.size() - 1) break;
            for (Integer neighbor : map.get(current)) {
                Integer newDist = distances.get(current) + 1;
                if (newDist < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    distances.put(neighbor, newDist);
                    queue.add(neighbor);
                }
            }
        }

        return distances.get(list.size() - 1);
    }
}