package sergeev.alexander.leetcode;

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

    // BEATS 88%
    public static int numSpecial(int[][] mat) {
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