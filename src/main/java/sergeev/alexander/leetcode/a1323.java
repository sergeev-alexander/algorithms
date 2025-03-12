package sergeev.alexander.leetcode;

// 1323. Maximum 69 Number
public class a1323 {

    /*
    You are given a positive integer num consisting only of digits 6 and 9.
    Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
     */

    public static void main(String[] args) {
        int num = 9699;
        System.out.println(maximum69Number(num));
    }

    // BEATS 100%
    public static int maximum69Number(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '6') {
                arr[i] = '9';
                return Integer.parseInt(new String(arr));
            }
        }
        return num;
    }

    // BEATS 23%
    public static int maximum69Number1(int num) {
        return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
    }
}