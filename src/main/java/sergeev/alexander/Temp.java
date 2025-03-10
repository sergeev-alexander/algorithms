package sergeev.alexander;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temp {

    public static void main(String[] args) {
        int[] arr = {3, 8, -10, 23, 19, -4, -14, 27};
        for (List<Integer> list : minimumAbsDifference(arr)) {
            System.out.println(list);
        }
    }

    // BEATS 66%
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int currDiff = Math.abs(arr[i] - arr[i + 1]);
            if (minDiff > currDiff) {
                result = new ArrayList<>();
                minDiff = currDiff;
                result.add(List.of(arr[i], arr[i + 1]));
            } else if (minDiff == currDiff) {
                result.add(List.of(arr[i], arr[i + 1]));
            }
        }
        return result;
    }

    // BEATS 23%
    public static List<List<Integer>> minimumAbsDifference1(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            minDiff = Math.min(minDiff, Math.abs(arr[i] - arr[i + 1]));
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) == minDiff) {
                result.add(List.of(arr[i], arr[i + 1]));
            }
        }
        return result;
    }
}