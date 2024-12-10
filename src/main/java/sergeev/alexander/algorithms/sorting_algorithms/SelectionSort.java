package sergeev.alexander.algorithms.sorting_algorithms;

import java.util.Arrays;
import java.util.List;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3, 5, 6};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minVal = array[i];
            int minPos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < minVal) {
                    minVal = array[j];
                    minPos = j;
                }
            }
            int temp = array[i];
            array[i] = array[minPos];
            array[minPos] = temp;
        }
    }

    private static <T extends Comparable<T>> List<T> typedSelectionSort(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            T min = list.get(i);
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (min.compareTo(list.get(j)) > 0) {
                    min = list.get(j);
                    minIndex = j;
                }
            }
            T temp = list.get(i);
            list.set(i, min);
            list.set(minIndex, temp);
        }
        return list;
    }
}