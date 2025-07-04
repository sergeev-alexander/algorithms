package sergeev.alexander;

public class Temp {

    public static void main(String[] args) {
        int[][] arr = {{1,10}, {10,20}};
        int left = 21, right = 21;
        System.out.println(isCovered(arr, left, right));
    }

    public static boolean isCovered(int[][] ranges, int left, int right) {
        for (int i = left; i <= right; i++) {
            boolean isCovered = false;

            for (int[] arr : ranges) {
                if (arr[0] <= i && arr[1] >= i) {
                    isCovered = true;
                    break;
                }
            }

            if (!isCovered) return false;
        }

        return true;
    }

    // BEATS 44%
    public static boolean isCovered1(int[][] ranges, int left, int right) {
        int[] array = new int[51];
        for (int[] arr : ranges) {
            for (int i = arr[0]; i <= arr[1]; i++) {
                array[i]++;
            }
        }
        for (int i = left; i <= right; i++) {
            if (array[i] == 0) return false;
        }
        return true;
    }
}