package sergeev.alexander.leetcode;

//1528. Shuffle String
public class a1528 {

    /*
    You are given a string s and an integer array indices of the same length.
    The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
    Return the shuffled string.
     */

    public static void main(String[] args) {
        String s = "codeleet";
        int[] arr = {4, 5, 6, 7, 0, 2, 1, 3};
        System.out.println(restoreString(s, arr));
    }

    // BEATS 100%
    public static String restoreString(String s, int[] indices) {
        char[] arr = new char[indices.length];
        for (int i = 0; i < arr.length; i++) {
            arr[indices[i]] = s.charAt(i);
        }
        return new String(arr);
    }

    // BEATS 72%
    public static String restoreString3(String s, int[] indices) {
        int n = indices.length;
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[indices[i]] = s.charAt(i);
        }
        return new String(arr);
    }

    // BEATS 72%
    public static String restoreString2(String s, int[] indices) {
        char[] word = s.toCharArray();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < indices.length; i++) {
            sb.setCharAt(indices[i], word[i]);
        }
        return sb.toString();
    }

    // BEATS 72%
    public static String restoreString1(String s, int[] indices) {
        int n = indices.length;
        char[] word = s.toCharArray();
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[indices[i]] = word[i];
        }
        return new String(arr);
    }
}