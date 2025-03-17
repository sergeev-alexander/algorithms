package sergeev.alexander.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 1380. Lucky Numbers in a Matrix
public class a1380 {

    /*
    Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
    A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
     */

    public static void main(String[] args) {
        int[][] m = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        System.out.println(luckyNumbers(m));
    }

    // BEATS 97%
    public static List<Integer> luckyNumbers(int[][] matrix) {
        for (int[] row : matrix) {
            final int minIndex = getMinIndex(row);
            if (row[minIndex] == maxNumOfColumn(matrix, minIndex)) {
                return List.of(row[minIndex]);
            }
        }
        return new ArrayList<>();
    }

    private static int getMinIndex(int[] row) {
        int minIndex = 0;
        for (int j = 0; j < row.length; ++j) {
            if (row[j] < row[minIndex]) {
                minIndex = j;
            }
        }
        return minIndex;
    }

    private static int maxNumOfColumn(int[][] matrix, int j) {
        int max = 0;
        for (int[] row : matrix) {
            max = Math.max(max, row[j]);
        }
        return max;
    }

    // BEATS 51%
    public static List<Integer> luckyNumbers2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] maxInColArr = new int[n];
        int[] minInRowArr = new int[m];
        Arrays.fill(minInRowArr, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minInRowArr[i] = Math.min(minInRowArr[i], matrix[i][j]);
                maxInColArr[j] = Math.max(maxInColArr[j], matrix[i][j]);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (minInRowArr[i] == maxInColArr[j]) {
                    list.add(minInRowArr[i]);
                }
            }
        }
        return list;
    }

    // BEATS 10%
    public static List<Integer> luckyNumbers1(int[][] matrix) {
        Set<Integer> minInRowSet = new HashSet<>();
        Set<Integer> maxInColSet = new HashSet<>();
        for (int[] row : matrix) {
            int minInRow = Integer.MAX_VALUE;
            for (int i : row) {
                minInRow = Math.min(minInRow, i);
            }
            minInRowSet.add(minInRow);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            int maxInCol = Integer.MIN_VALUE;
            for (int[] row : matrix) {
                maxInCol = Math.max(maxInCol, row[j]);
            }
            maxInColSet.add(maxInCol);
        }
        for (int num : maxInColSet) {
            if (minInRowSet.contains(num)) {
                return List.of(num);
            }
        }
        return Collections.emptyList();
    }
}