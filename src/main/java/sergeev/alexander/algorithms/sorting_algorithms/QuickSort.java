package sergeev.alexander.algorithms.sorting_algorithms;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {7, 6, 8, 9, 2, 1, 3, 5, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSortComplete(int[] arr, int leftIndex, int rightIndex) {
        if (arr.length == 0 || leftIndex >= rightIndex) return;
        int pivotValue = arr[(leftIndex + rightIndex) / 2];
        int leftMarkerIndex = leftIndex;
        int rightMarkerIndex = rightIndex;
        while (leftMarkerIndex <= rightMarkerIndex) {
            while (arr[leftMarkerIndex] < pivotValue) leftMarkerIndex++;
            while (arr[rightMarkerIndex] > pivotValue) rightMarkerIndex--;
            if (leftMarkerIndex <= rightMarkerIndex) {
                int temp = arr[leftMarkerIndex];
                arr[leftMarkerIndex] = arr[rightMarkerIndex];
                arr[rightMarkerIndex] = temp;
                leftMarkerIndex++;
                rightMarkerIndex--;
            }
        }
        if (leftIndex < rightMarkerIndex) quickSortComplete(arr, leftIndex, rightMarkerIndex);
        if (rightIndex > leftMarkerIndex) quickSortComplete(arr, leftMarkerIndex, rightIndex);
    }

    public static void quickSort(int[] array, int leftPos, int rightPos) {
        if (leftPos < rightPos) {
            int pivotPos = partition(array, leftPos, rightPos);
            quickSort(array, leftPos, pivotPos - 1);
            quickSort(array, pivotPos, rightPos);
        }
    }

    private static int partition(int[] array, int leftPos, int rightPos) {
        int pivotValue = array[(leftPos + rightPos) / 2];
        while (leftPos <= rightPos) {
            while (array[leftPos] < pivotValue) leftPos++;
            while (array[rightPos] > pivotValue) rightPos--;
            if (leftPos <= rightPos) {
                swap(array, leftPos++, rightPos--);
            }
        }
        return leftPos;
    }

    private static void swap(int[] array, int leftPos, int rightPos) {
        int temp = array[leftPos];
        array[leftPos] = array[rightPos];
        array[rightPos] = temp;
    }
}