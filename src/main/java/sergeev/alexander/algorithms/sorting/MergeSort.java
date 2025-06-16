package sergeev.alexander.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2,3,9,2,9};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        int length = arr.length;
        if (length == 1) return;
        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[i + mid];
        }
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] destArr, int[] leftArr, int[] rightArr) {
        int leftLength = leftArr.length;
        int rightLength = rightArr.length;
        int leftIndex = 0;
        int rightIndex = 0;
        int arrIndex = 0;
        while (leftIndex < leftLength && rightIndex < rightLength) {
            if (leftArr[leftIndex] < rightArr[rightIndex]) {
                destArr[arrIndex++] = leftArr[leftIndex++];
            } else destArr[arrIndex++] = rightArr[rightIndex++];
        }
        for (int i = leftIndex; i < leftLength; i++) {
            destArr[arrIndex++] = leftArr[i];
        }
        for (int i = rightIndex; i < rightLength; i++) {
            destArr[arrIndex++] = rightArr[i];
        }
    }
}