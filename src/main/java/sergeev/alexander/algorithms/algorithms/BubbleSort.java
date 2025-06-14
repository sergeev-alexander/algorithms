package sergeev.alexander.algorithms.algorithms;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {6, 5, 7, 4, 8, 0, 2, 3, 1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] array) {
        int endOfSortPos = array.length;
        int lastPos = 0;
        while (endOfSortPos > 0) {
            for (int i = 1; i < endOfSortPos; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    lastPos = i;
                }
            }
            endOfSortPos = lastPos;
            lastPos = 0;
        }
    }
}