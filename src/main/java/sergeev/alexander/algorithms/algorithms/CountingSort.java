package sergeev.alexander.algorithms.algorithms;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] arr = {4,5,3,1,2};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void countingSort(int[] array) {
        int min = 0;
        int max = 0;

        for (int num : array) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int dif = max - min + 1;
        int[] countArray = new int[dif];

        for (int num : array) {
            countArray[num - min]++;
        }

        int pos = 0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                array[pos++] = i + min;
                countArray[i]--;
            }
        }
    }
}
