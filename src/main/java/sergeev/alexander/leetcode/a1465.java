package sergeev.alexander.leetcode;

import java.util.Arrays;

// 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
public class a1465 {

    /*
    You are given a rectangular cake of size h x w and two arrays of integers horizontalCuts and verticalCuts where:
    horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly,
    and verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
    Return the maximum area of a piece of cake after you cut at each horizontal
    and vertical position provided in the arrays horizontalCuts and verticalCuts.
    Since the answer can be a large number, return this modulo 109 + 7.
     */

    public static void main(String[] args) {
        int h = 1_000_000_000;
        int w = 1_000_000_000;
        int[] hc = {2};
        int[] vc = {2};
        System.out.println(maxArea(h, w, hc, vc));
    }

    // BEATS 92%
    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int n1 = horizontalCuts.length;
        Arrays.sort(horizontalCuts);
        int lastCut1 = h - horizontalCuts[n1 - 1];
        int max1 = Math.max(horizontalCuts[0], lastCut1);
        for (int i = 1; i < n1; i++) {
            max1 = Math.max(max1, horizontalCuts[i] - horizontalCuts[i - 1]);
        }

        int n2 = verticalCuts.length;
        Arrays.sort(verticalCuts);
        int lastCut2 = w - verticalCuts[n2 - 1];
        int max2 = Math.max(verticalCuts[0], lastCut2);
        for (int i = 1; i < n2; i++) {
            max2 = Math.max(max2, verticalCuts[i] - verticalCuts[i - 1]);
        }

        int MOD = (int) 1e9 + 7;
        long result = ((long) max1 * max2) % MOD;
        return (int) result;
    }

    // BEATS 46%
    public static int maxArea1(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int n1 = horizontalCuts.length;
        int[] arr1 = new int[n1 + 2];
        arr1[0] = 0;
        arr1[n1 + 1] = h;
        System.arraycopy(horizontalCuts, 0, arr1, 1, n1);
        Arrays.sort(arr1);

        int max1 = 0;
        for (int i = 1; i < arr1.length; i++) {
            max1 = Math.max(max1, arr1[i] - arr1[i - 1]);
        }

        int n2 = verticalCuts.length;
        int[] arr2 = new int[n2 + 2];
        arr2[0] = 0;
        arr2[n2 + 1] = w;
        System.arraycopy(verticalCuts, 0, arr2, 1, n2);
        Arrays.sort(arr2);

        int max2 = 0;
        for (int i = 1; i < arr2.length; i++) {
            max2 = Math.max(max2, arr2[i] - arr2[i - 1]);
        }

        int MOD = (int) 1e9 + 7;
        long result = ((long) max1 * max2) % MOD;
        return (int) result;
    }
}