package sergeev.alexander.leetcode;

// 2293. Min Max Game
public class a2293 {

    /*
    You are given a 0-indexed integer array nums whose length is a power of 2.
    Apply the following algorithm on nums:
    Let n be the length of nums. If n == 1, end the process. Otherwise, create a new 0-indexed integer array newNums of length n / 2.
    For every even index i where 0 <= i < n / 2, assign the value of newNums[i] as min(nums[2 * i], nums[2 * i + 1]).
    For every odd index i where 0 <= i < n / 2, assign the value of newNums[i] as max(nums[2 * i], nums[2 * i + 1]).
    Replace the array nums with newNums.
    Repeat the entire process starting from step 1.
    Return the last number that remains in nums after applying the algorithm.
     */

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 4, 8, 2, 2};
        System.out.println(minMaxGame(arr));
    }

    // BEATS 65%
    public static int minMaxGame(int[] nums) {
        int size = nums.length;
        int pos = 0;

        while (size > 1) {

            for (int i = 0, j = 1; i < size; i += 2, j += 2) {
                if (pos % 2 == 0) {
                    nums[pos++] = Math.min(nums[i], nums[j]);
                } else {
                    nums[pos++] = Math.max(nums[i], nums[j]);
                }
            }
            size /= 2;
            pos = 0;
        }

        return nums[0];
    }

    // BEATS 65%
    public static int minMaxGame1(int[] nums) {
        int size = nums.length;
        int pos = 0;

        while (size > 1) {

            for (int i = 0, j = 1; i < size; i += 2, j += 2) {
                if (pos % 2 == 0) {
                    nums[pos++] = Math.min(nums[i], nums[j]);
                } else {
                    nums[pos++] = Math.max(nums[i], nums[j]);
                }
            }
            size /= 2;
            pos = 0;
        }

        return nums[0];
    }
}