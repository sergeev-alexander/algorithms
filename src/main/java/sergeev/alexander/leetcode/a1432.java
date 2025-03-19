package sergeev.alexander.leetcode;

// 1432. Max Difference You Can Get From Changing an Integer
public class a1432 {

    /*
    You are given an integer num. You will apply the following steps exactly two times:
    Pick a digit x (0 <= x <= 9).
    Pick another digit y (0 <= y <= 9). The digit y can be equal to x.
    Replace all the occurrences of x in the decimal representation of num by y.
    The new integer cannot have any leading zeros, also the new integer cannot be 0.
    Let a and b be the results of applying the operations to num the first and second times, respectively.
    Return the max difference between a and b.
     */

    public static void main(String[] args) {
        int num = 111;
        System.out.println(maxDiff(num));
    }

    // BEATS 98%
    public static int maxDiff(int num) {
        String numString = String.valueOf(num);
        int n = numString.length();
        char[] arr1 = numString.toCharArray();
        char[] arr2 = new char[n];
        System.arraycopy(arr1, 0, arr2, 0, n);
        boolean found = false;
        char toReplace = 'a';
        char replacement = '9';
        for (int i = 0; i < n; i++) {
            if (!found) {
                if (arr1[i] < replacement) {
                    toReplace = arr1[i];
                    arr1[i] = replacement;
                    found = true;
                }
            } else {
                if (arr1[i] == toReplace) {
                    arr1[i] = replacement;
                }
            }
        }
        found = false;
        for (int i = 0; i < n; i++) {
            if (!found) {
                if (i > 0 && arr2[i] > '0' && arr2[i] != arr2[0]) {
                    toReplace = arr2[i];
                    replacement = '0';
                    arr2[i] = replacement;
                    found = true;
                } else if (i == 0 && arr2[i] > '1') {
                    toReplace = arr2[i];
                    replacement = '1';
                    arr2[i] = replacement;
                    found = true;
                }
            } else {
                if (arr2[i] == toReplace) {
                    arr2[i] = replacement;
                }
            }
        }
        return Integer.parseInt(new String(arr1)) - Integer.parseInt(new String(arr2));
    }

    // BEATS 14%
    public static int maxDiff1(int num) {
        String numString = String.valueOf(num);
        String num1 = numString;
        String num2 = numString;
        char[] arr = numString.toCharArray();
        boolean a = false;
        boolean b = false;
        for (int i = 0; i < arr.length; i++) {
            if (a && b) break;
            if (!a && arr[i] - '0' < 9) {
                num1 = num1.replaceAll(String.valueOf(arr[i]), "9");
                a = true;
            }
            if (!b && i > 0 && arr[i] - '0' > 0 && arr[0] != arr[i]) {
                num2 = num2.replaceAll(String.valueOf(arr[i]), "0");
                b = true;
            } else if (!b && i == 0 && arr[i] - '0' > 1) {
                num2 = num2.replaceAll(String.valueOf(arr[i]), "1");
                b = true;
            }
        }
        return Integer.parseInt(num1) - Integer.parseInt(num2);
    }
}