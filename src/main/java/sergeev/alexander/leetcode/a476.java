package sergeev.alexander.leetcode;

// 476. Number Complement
public class a476 {

    /*
    The complement of an integer is the integer you get when you flip all the 0's to 1's
    and all the 1's to 0's in its binary representation.
    For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
    Given an integer num, return its complement.
     */

    public static void main(String[] args) {
        int num = 5;
        System.out.println(findComplement(num));
    }

    // BEATS 100%
    public static int findComplement(int num) {
        if (num == 0) return 1;
        int ans = 0;
        int i = 0;
        while (num > 0) {

            if (num % 2 == 0) {
                ans += (int) Math.pow(2, i);
            }

            i++;
            num /= 2;
        }
        return ans;
    }

    // BEATS 33%
    public static int findComplement1(int num) {
        String binary = Integer.toBinaryString(num);
        char[] arr = binary.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') arr[i] = '1';
            else arr[i] = '0';
        }
        return Integer.parseInt(new String(arr), 2);
    }
}