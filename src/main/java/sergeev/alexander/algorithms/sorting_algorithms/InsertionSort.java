package sergeev.alexander.algorithms.sorting_algorithms;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {8, 1, 7, 2, 6, 0, 0, 3, 5, 4};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currentNum = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > currentNum) {
                arr[j] = arr[--j];
            }
            arr[j] = currentNum;
        }
    }
}

