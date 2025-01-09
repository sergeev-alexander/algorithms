package sergeev.alexander.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

// 2558. Take Gifts From the Richest Pile
public class a2558 {

    /*
    You are given an integer array gifts denoting the number of gifts in various piles.
    Every second, you do the following:
    Choose the pile with the maximum number of gifts.
    If there is more than one pile with the maximum number of gifts, choose any.
    Reduce the number of gifts in the pile to the floor of the square root of the original number of gifts in the pile.
    Return the number of gifts remaining after k seconds.
     */

    public static void main(String[] args) {
        int[] gifts = {25,64,9,4,100};
        int k = 4;
        System.out.println(pickGifts(gifts, k));
    }

    // BEATS 91%
    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : gifts) {
            priorityQueue.add(num);
        }
        while (!priorityQueue.isEmpty() && k > 0) {
            priorityQueue.add((int) Math.sqrt(priorityQueue.poll()));
            k--;
        }
        long sum = 0L;
        for (int num : priorityQueue) {
            sum += num;
        }
        return sum;
    }
}