package sergeev.alexander.algorithms.sorting;

import java.util.Scanner;

public class ArrayInversionCountUsingMergeSort {

    static long count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        mergeSort(arr);
        System.out.println(count);
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
            if (leftArr[leftIndex] <= rightArr[rightIndex]) {
                destArr[arrIndex++] = leftArr[leftIndex++];
            } else {
                count += leftLength - leftIndex;
                destArr[arrIndex++] = rightArr[rightIndex++];
            }
        }
        for (int i = leftIndex; i < leftLength; i++) {
            destArr[arrIndex++] = leftArr[i];
        }
        for (int i = rightIndex; i < rightLength; i++) {
            destArr[arrIndex++] = rightArr[i];
        }
    }
}

