package sergeev.alexander.leetcode;

import java.util.ArrayList;
import java.util.List;

// 1582. Special Positions in a Binary Matrix
public class a1582 {

    /*
    Given an m x n binary matrix mat, return the number of special positions in mat.
    A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).
     */

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(numSpecial(grid));
    }

    // BEATS 93%
    public static int numSpecial(int[][] mat) {
        int m = mat[0].length;
        int[] colArr = new int[m];
        boolean[] badCols = new boolean[m];

        for (int j = 0; j < m; j++) {
            for (int[] rows : mat) {
                if (rows[j] == 1 && ++colArr[j] > 1) {
                    badCols[j] = true;
                    break;
                }
            }
        }

        int count = 0;

        for (int[] rows : mat) {
            int colPos = -1;
            boolean isValid = true;

            for (int j = 0; j < m; j++) {
                if (rows[j] == 1) {
                    if (colPos != -1) {
                        isValid = false;
                        break;
                    }
                    colPos = j;
                }
            }

            if (isValid && colPos != -1 && !badCols[colPos]) {
                count++;
            }
        }

        return count;
    }

    // BEATS 93%
    public static int numSpecial3(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] rowArr = new int[n];
        int[] colArr = new int[m];
        boolean[] badRows = new boolean[n];
        boolean[] badCols = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    if (++rowArr[i] > 1) badRows[i] = true;
                    if (++colArr[j] > 1) badCols[j] = true;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (badRows[i]) continue;
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && !badCols[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    // BEATS 88%
    public static int numSpecial2(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] rowArr = new int[n];
        int[] colArr = new int[m];
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    list.add(new int[]{i, j});
                    rowArr[i]++;
                    colArr[j]++;
                }
            }
        }

        int count = 0;

        for (int[] arr : list) {
            if (rowArr[arr[0]] == 1 && colArr[arr[1]] == 1) count++;
        }

        return count;
    }

    // BEATS 88%
    public static int numSpecial1(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] rowArr = new int[n];
        int[] colArr = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    rowArr[i]++;
                    colArr[j]++;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && rowArr[i] == 1 && colArr[j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}