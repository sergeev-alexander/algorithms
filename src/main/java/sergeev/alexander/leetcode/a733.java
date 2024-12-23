package sergeev.alexander.leetcode;

import java.util.Arrays;

// 733. Flood Fill
public class a733 {

    /*
    You are given an image represented by an m x n grid of integers image,
    where image[i][j] represents the pixel value of the image.
    You are also given three integers sr, sc, and color.
    Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].
    To perform a flood fill:
    Begin with the starting pixel and change its color to color.
    Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel,
    either horizontally or vertically) and shares the same color as the starting pixel.
    Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color
    if it matches the original color of the starting pixel.
    The process stops when there are no more adjacent pixels of the original color to update.
    Return the modified image after performing the flood fill.
     */

    public static void main(String[] args) {
        int[][] grid = {
                {1,1,1},
                {1,1,0},
                {1,0,1}};
        for (int[] arr : floodFill(grid, 1, 1, 2)) {
            System.out.println(Arrays.toString(arr));
        }
    }

    // BEATS 100%
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor == color) return image;
        fill(image, sr, sc, oldColor, color);
        return image;
    }

    private static void fill(int[][] gird, int m, int n, int oldColor, int newColor) {
        if (m >= 0 && m < gird.length && n >= 0 && n < gird[m].length && gird[m][n] == oldColor) {
            gird[m][n] = newColor;
            fill(gird, m + 1, n, oldColor, newColor);
            fill(gird, m - 1, n, oldColor, newColor);
            fill(gird, m, n + 1, oldColor, newColor);
            fill(gird, m, n - 1, oldColor, newColor);
        }
    }
}