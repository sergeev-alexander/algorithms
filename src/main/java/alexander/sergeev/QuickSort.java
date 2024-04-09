package alexander.sergeev;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {2, 4, 6, 9, 7};

        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort1(int[] arr, int leftIndex, int rightIndex) {
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
        if (leftIndex < rightMarkerIndex) quickSort1(arr, leftIndex, rightMarkerIndex);
        if (rightIndex > leftMarkerIndex) quickSort1(arr, leftMarkerIndex, rightIndex);
    }

}
