package sergeev.alexander.algorithms;

public class AscDescRecursiveSearch {

    public static void main(String[] args) {

        int[] arrayAsc = {1, 2, 5, 8, 12, 13, 20, 22, 24, 30, 32};

        int[] arrayDesc = {32, 30, 24, 22, 20, 13, 12,  8,  5,  2, 1};

        System.out.println("Индекс искомого элемента: " + searchBinaryAscending(arrayAsc, 30));
        System.out.println("Индекс искомого элемента: " + searchBinaryDescending(arrayDesc, 30));
        System.out.println("Индекс искомого элемента: " + searchBinary(arrayAsc, 30));
        System.out.println("Индекс искомого элемента: " + searchBinary(arrayDesc, 30));
    }

    private static int searchBinary(int[] array, int elem) {
        // возвращает 1, если массив отсортирован по возрастанию, и -1, если по убыванию
        int sort = getSortRecursive(array, 0, 0);
        if(sort > 0){
            return  searchBinaryAscending(array, elem);
        } else if (sort < 0){
            return searchBinaryDescending(array, elem);
        } else {
            return -1;
        }
    }

    private static int getSortRecursive(int[] array, int sort, int next) {
        if (next == array.length - 1) {
            return sort;
        }
        if (array[next] > array[next + 1]) {
            if (sort == 1) return 0;
            return getSortRecursive(array, -1, next + 1);
        }
        if (array[next] < array[next + 1]) {
            if (sort == -1) return 0;
            return getSortRecursive(array, 1, next + 1);
        }
        return sort;
    }

    private static int searchBinaryAscending(int[] arr, int elem) {
        return myASCSearch(arr, elem, 0, arr.length - 1);
    }

    private static int searchBinaryDescending(int[] arr, int elem) {
        return myDESCSearch(arr, elem, 0, arr.length - 1);
    }

    private static int myASCSearch(int[] arr, int elem, int left, int right) {
        if (left >= right) return -1;
        int mid = (left + right) / 2;
        if (elem == arr[mid]) return mid;
        if (elem < arr[mid]) return myASCSearch(arr, elem, left, mid - 1);
        else return myASCSearch(arr, elem, mid + 1, right);
    }

    private static int myDESCSearch(int[] arr, int elem, int left, int right) {
        if (left >= right) return -1;
        int mid = (left + right) / 2;
        if (elem == arr[mid]) return mid;
        if (elem < arr[mid]) return myDESCSearch(arr, elem, mid + 1, right);
        else return myDESCSearch(arr, elem, left, mid);
    }

}
