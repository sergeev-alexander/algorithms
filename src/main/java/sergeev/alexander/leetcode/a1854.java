package sergeev.alexander.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// 1854. Maximum Population Year
public class a1854 {

    /*
    You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.
    The population of some year x is the number of people alive during that year.
    The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1].
    Note that the person is not counted in the year that they die.
    Return the earliest year with the maximum population.
     */

    public static void main(String[] args) {
        int[][] arr = {{1950, 1961}, {1960, 1971}, {1970, 1981}};
        System.out.println(maximumPopulation(arr));
    }

    public static int maximumPopulation(int[][] logs) {
        int[] arr = new int[100];

        for (int[] log : logs) {
            arr[log[0] - 1950]++;
            arr[log[1] - 1950]--;
        }

        int max = 0;
        int current = 0;
        int year = 0;

        for (int i = 0; i < arr.length; i++) {
            current += arr[i];
            if (current > max) {
                max = current;
                year = i + 1950;
            }
        }

        return year;
    }

    // BEATS 8%
    public static int maximumPopulation3(int[][] logs) {
        List<Event> eventList = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            eventList.add(new Event(i, logs[i][0], true));
            eventList.add(new Event(i, logs[i][1], false));
        }

        eventList.sort((a, b) -> {
            if (a.year != b.year) {
                return a.year - b.year;
            }
            return a.isStart ? 1 : -1;
        });

        int max = 0;
        int minYear = 0;
        int current = 0;
        for (Event event : eventList) {
            if (event.isStart) {
                current++;
            } else {
                current--;
            }
            if (current > max) {
                max = current;
                minYear = event.year;
            }
        }
        return minYear;
    }

    static class Event {

        int id;
        int year;
        boolean isStart;

        public Event(int id, int year, boolean isStart) {
            this.id = id;
            this.year = year;
            this.isStart = isStart;
        }
    }

    // BEATS 29%
    public static int maximumPopulation2(int[][] logs) {
        int[] arr = new int[100];
        int max = 0;

        for (int[] log : logs) {
            for (int j = log[0]; j < log[1]; j++) {
                max = Math.max(max, ++arr[j - 1950]);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                return i + 1950;
            }
        }

        return -1;
    }

    // BEATS 5%
    public static int maximumPopulation1(int[][] logs) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int max = 0;

        for (int[] arr : logs) {
            for (int i = arr[0]; i < arr[1]; i++) {
                max = Math.max(max, map.merge(i, 1, Integer::sum));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                return entry.getKey();
            }
        }

        return -1;
    }
}