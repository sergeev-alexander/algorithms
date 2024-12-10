package sergeev.alexander.algorithms.sorting_algorithms;

import java.util.Arrays;

public class BogoSort {

    public static void main(String[] args) {
        int[] array = {6, 5, 7, 4, 8, 0, 2, 3, 1};
        bogoSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void bogoSort(int[] array) {
        while (!isSorted(array)) {
            shuffle(array);
        }
    }

    private static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) return false;
        }
        return true;
    }

    private static void shuffle(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int randomPos = (int) (Math.random() * array.length);
            int temp = array[i];
            array[i] = array[randomPos];
            array[randomPos] = temp;
        }
    }
}