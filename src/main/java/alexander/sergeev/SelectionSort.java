package alexander.sergeev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort {

    public static void main(String[] args) {

        Integer[] arr = {4, 2, 1, 3, 5, 6};
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));

        System.out.println(Arrays.toString(selectionSort(arr)));
        System.out.println(typedSelectionSort(list));
    }

    public static Integer[] selectionSort(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[minIndex] = temp;
        }
        return arr;
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
