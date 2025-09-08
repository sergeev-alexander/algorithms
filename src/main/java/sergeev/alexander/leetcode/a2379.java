package sergeev.alexander.leetcode;

// 2379. Minimum Recolors to Get K Consecutive Black Blocks
public class a2379 {

    /*
    You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block.
    The characters 'W' and 'B' denote the colors white and black, respectively.
    You are also given an integer k, which is the desired number of consecutive black blocks.
    In one operation, you can recolor a white block such that it becomes a black block.
    Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.
     */

    public static void main(String[] args) {
        String s = "WBWBBBW";
        int k = 2;
        System.out.println(minimumRecolors(s, k));
    }

    // BEATS 100%
    public static int minimumRecolors(String blocks, int k) {
        char[] arr = blocks.toCharArray();

        int count = 0;

        for (int i = 0; i < k; i++) {
            if (arr[i] == 'W') count++;
        }

        int min = count;

        for (int i = 0, j = k; j < arr.length; i++, j++) {
            if (arr[i] == 'W') count--;
            if (arr[j] == 'W') count++;
            min = Math.min(min, count);
        }

        return min;
    }
}