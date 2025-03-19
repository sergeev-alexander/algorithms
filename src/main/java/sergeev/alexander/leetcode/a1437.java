package sergeev.alexander.leetcode;

// 1437. Check If All 1's Are at Least Length K Places Away
public class a1437 {

    /*
    Given an binary array nums and an integer k, return true if all 1's are at least k places away from each other,
    otherwise return false.
     */

    public static void main(String[] args) {
        int[] arr = {1,0,0,1,0, 0,1};
        int k = 2;
        System.out.println(kLengthApart(arr, k));
    }

    // BEATS 100%
    public static boolean kLengthApart(int[] nums, int k) {
        int lastOne = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (lastOne < 0) lastOne = i;
                else {
                    if (i - lastOne - 1 < k) return false;
                    else lastOne = i;
                }
            }
        }
        return true;
    }

    // BEATS 27%
    public static boolean kLengthApart1(int[] nums, int k) {
        int count = 0;
        boolean was = false;
        for (int num : nums) {
            if (was) {
                if (num == 0) count++;
                else if (num == 1 && count < k) return false;
                else if (num == 1) count = 0;
            }
            if (num == 1) {
                was = true;
            }
        }
        return true;
    }
}