package sergeev.alexander.algorithms;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {2,1,3,3};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (arr.length == 0 || leftIndex >= rightIndex) return;
        int pivot = arr[(leftIndex + rightIndex) / 2];
        int leftMarkerIndex = leftIndex;
        int rightMarkerIndex = rightIndex;
        while (leftMarkerIndex <= rightMarkerIndex) {
            while (arr[leftMarkerIndex] < pivot) leftMarkerIndex++;
            while (arr[rightMarkerIndex] > pivot) rightMarkerIndex--;
            if (leftMarkerIndex <= rightMarkerIndex) {
                int temp = arr[leftMarkerIndex];
                arr[leftMarkerIndex] = arr[rightMarkerIndex];
                arr[rightMarkerIndex] = temp;
                leftMarkerIndex++;
                rightMarkerIndex--;
            }
        }
        if (leftIndex < rightMarkerIndex) quickSort(arr, leftIndex, rightMarkerIndex);
        if (rightIndex > leftMarkerIndex) quickSort(arr, leftMarkerIndex, rightIndex);
    }

}
