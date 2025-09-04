package sergeev.alexander.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 2231. Largest Number After Digit Swaps by Parity
public class a2231 {

    /*
    You are given a positive integer num. You may swap any two digits of num that have the same parity
    (i.e. both odd digits or both even digits).
    Return the largest possible value of num after any number of swaps.
     */

    public static void main(String[] args) {
        int num = 1234;
        System.out.println(largestInteger(num));
    }

    // BEATS 96%
    public static int largestInteger(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] % 2 == 0 && arr[j] % 2 == 0 || arr[i] % 2 != 0 && arr[j] % 2 != 0) && arr[j] > arr[i]) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return Integer.parseInt(new String(arr));
    }

    // BEATS 80%
    public static int largestInteger1(int num) {
        List<Character> oddList = new ArrayList<>();
        List<Character> evenList = new ArrayList<>();
        char[] arr = String.valueOf(num).toCharArray();

        for (char ch : arr) {
            if (ch % 2 == 0) evenList.add(ch);
            else oddList.add(ch);
        }

        oddList.sort(Comparator.reverseOrder());
        evenList.sort(Comparator.reverseOrder());

        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) arr[i] = evenList.get(evenCount++);
            else arr[i] = oddList.get(oddCount++);
        }

        return Integer.parseInt(new String(arr));
    }
}