package sergeev.alexander;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Temp {

    public static void main(String[] args) {
        int[][] arr = {{4,8},{3,6},{10,20},{15,30}};
        System.out.println(interchangeableRectangles(arr));
    }

    // BEATS 97%
    public static long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Integer> map = new HashMap<>();

        for (int[] arr : rectangles) {
            map.merge((double) arr[0] / arr[1], 1, Integer::sum);
        }

        long count = 0;
        for (int val : map.values()) {
            if (val > 1) count+= (long) val * (val - 1) / 2;
        }

        return count;
    }

    // TLE
    public static long interchangeableRectangles1(int[][] rectangles) {
        int n = rectangles.length;
        long count = 0;

        for (int i = 0; i < n - 1; i++) {
            double currentRatio = (double) rectangles[i][0] / rectangles[i][1];
            for (int j = i + 1; j < n; j++) {
                if (currentRatio == (double) rectangles[j][0] / rectangles[j][1]) count++;
            }
        }

        return count;
    }
}