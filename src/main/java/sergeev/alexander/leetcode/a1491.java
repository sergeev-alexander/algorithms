package sergeev.alexander.leetcode;

import java.util.Arrays;

// 1491. Average Salary Excluding the Minimum and Maximum Salary
public class a1491 {

    /*
    You are given an array of unique integers salary where salary[i] is the salary of the ith employee.
    Return the average salary of employees excluding the minimum and maximum salary.
    Answers within 10-5 of the actual answer will be accepted.
     */

    public static void main(String[] args) {
        int[] arr = {4000,3000,1000,2000};
        System.out.println(average(arr));
    }

    // BEATS 100%
    public static double average1(int[] salary) {
        Arrays.sort(salary);
        int sum = 0;
        for (int i = 1; i < salary.length - 1; i++) {
            sum += salary[i];
        }
        return (double) sum / (salary.length - 2);
    }

    // BEATS 100%
    public static double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : salary) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return (double) (sum - min - max) / (salary.length - 2);
    }
}