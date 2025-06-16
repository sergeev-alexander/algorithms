package sergeev.alexander.diverse_tasks;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 0, 6, 7, 9, 8};
        Integer[] array = {1, 3, 5, 2, 0, 6, 7, 9, 8};
        int num = 8;
        System.out.println(binarySearch(arr, num));
        System.out.println(binarySearch1(num, 1, 3, 5, 2, 0, 6, 7, 9, 8));
        System.out.println(binaryRecursiveSearch(arr, num, 0, arr.length - 1));
        System.out.println(typedBinaryRecursiveSearch(Arrays.asList(array), num, 0, array.length - 1));

    }

    public static Integer binarySearch(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            int currentElement = arr[mid];
            if (currentElement == num) return mid;
            if (currentElement > num) right = mid - 1;
            else left = mid + 1;
        }
        return null;
    }

    public static Integer binarySearch1(int num, int... arr) {
        int left = arr[0];
        int right = arr[arr.length - 1];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == num) return mid;
            if (arr[mid] > num) right = mid - 1;
            else left = mid + 1;
        }
        return null;
    }

    private static int binaryRecursiveSearch(int[] array, int elem, int left, int right) {
        if (left >= right) {
            return -1;
        }
        int mid = (right + left) / 2;
        if (array[mid] == elem) {
            return mid;
        } else if (elem < array[mid]) {
            return binaryRecursiveSearch(array, elem, left, mid - 1);
        } else {
            return binaryRecursiveSearch(array, elem, mid + 1, right);
        }
    }

    private static <T extends Comparable<T>> int typedBinaryRecursiveSearch(List<T> list, T elem, int left, int right) {
        if (left >= right) return -1;
        int mid = (left + right) / 2;
        if (list.get(mid).equals(elem)) return mid;
        if (elem.compareTo(list.get(mid)) < 0) {
            return typedBinaryRecursiveSearch(list, elem, left, mid - 1);
        } else {
            return typedBinaryRecursiveSearch(list, elem, mid + 1, right);
        }
    }

}
