package sergeev.alexander;

public class Temp {

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

