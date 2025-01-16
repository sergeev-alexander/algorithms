package sergeev.alexander.leetcode;

// 2500. Delete Greatest Value in Each Row
public class a2500 {

    /*
    You are given an m x n matrix grid consisting of positive integers.
    Perform the following operation until grid becomes empty:
    Delete the element with the greatest value from each row. If multiple such elements exist, delete any of them.
    Add the maximum of deleted elements to the answer.
    Note that the number of columns decreases by one after each operation.
    Return the answer after performing the operations described above.
     */

    public static void main(String[] args) {
        int[][] grid = {{1,2,4},{3,3,1}};
        System.out.println(deleteGreatestValue(grid));
    }

    // BEATS 22%
    public static int deleteGreatestValue(int[][] grid) {
        boolean[][] arr = new boolean[grid.length][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new boolean[grid[0].length];
        }
        int sum = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                int maxInRow = 0;
                int row = 0;
                int col = 0;
                for (int k = 0; k < grid[j].length; k++) {
                    if (!arr[j][k] && grid[j][k] >= maxInRow) {
                        maxInRow = grid[j][k];
                        row = j;
                        col = k;
                    }
                }
                arr[row][col] = true;
                if (maxInRow >= max) {
                    max = maxInRow;
                }
            }
            sum += max;
        }
        return sum;
    }
}