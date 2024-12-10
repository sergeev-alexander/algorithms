package sergeev.alexander.algorithms.sorting_algorithms;

import java.util.Arrays;

public class CombSort {

    public static void main(String[] args) {
        int[] arr = {6, 5, 7, 4, 8, 0, 2, 3, 1};
        combSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void combSort(int[] array) {
        int gap = array.length;
        boolean isSorted = false;
        while (!isSorted || gap > 1) {
            isSorted = true;
            if (gap > 1) gap /= 1.247;
            else gap = 1;
            for (int i = gap; i < array.length; i++) {
                if (array[i - gap] > array[i]) {
                    int temp = array[i - gap];
                    array[i - gap] = array[i];
                    array[i] = temp;
                    isSorted = false;
                }
            }
        }
    }
}
