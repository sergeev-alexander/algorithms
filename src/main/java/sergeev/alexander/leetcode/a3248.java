package sergeev.alexander.leetcode;

import java.util.List;

// 3248. Snake in Matrix
public class a3248 {

    /*
    There is a snake in an n x n matrix grid and can move in four possible directions.
    Each cell in the grid is identified by the position: grid[i][j] = (i * n) + j.
    The snake starts at cell 0 and follows a sequence of commands.
    You are given an integer n representing the size of the grid
    and an array of strings commands where each command[i] is either "UP", "RIGHT", "DOWN", and "LEFT".
    It's guaranteed that the snake will remain within the grid boundaries throughout its movement.
    Return the position of the final cell where the snake ends up after executing commands.
     */

    public static void main(String[] args) {
        int n = 3;
        List<String> list = List.of("DOWN", "RIGHT", "UP");
        System.out.println(finalPositionOfSnake(n, list));
    }

    // BEATS 91%
    public static int finalPositionOfSnake(int n, List<String> commands) {
        int x = 0, y = 0;

        for (String s : commands) {
            switch (s) {
                case "UP" -> y--;
                case "RIGHT" -> x++;
                case "DOWN" -> y++;
                case "LEFT" -> x--;
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == y && j == x) return count;
                count++;
            }
        }

        return count;
    }

    // BEATS 11%
    public static int finalPositionOfSnake1(int n, List<String> commands) {
        int[][] mat = new int[n][n];

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = count++;
            }
        }

        int x = 0, y = 0;

        for (String s : commands) {
            switch (s) {
                case "UP" -> y--;
                case "RIGHT" -> x++;
                case "DOWN" -> y++;
                case "LEFT" -> x--;
            }
        }

        return mat[y][x];
    }
}