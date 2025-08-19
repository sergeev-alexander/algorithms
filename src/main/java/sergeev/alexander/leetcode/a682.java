package sergeev.alexander.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

// 682. Baseball Game
public class a682 {

    /*
    You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.
    You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:
    An integer x.
    Record a new score of x.
    '+'.
    Record a new score that is the sum of the previous two scores.
    'D'.
    Record a new score that is the double of the previous score.
    'C'.
    Invalidate the previous score, removing it from the record.
    Return the sum of all the scores on the record after applying all the operations.
    The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer and that all operations are valid.
     */

    public static void main(String[] args) {
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(ops));
    }

    // BEATS 94%
    public static int calPoints(String[] operations) {
        Deque<Integer> deque = new ArrayDeque<>();
        int sum = 0;

        for (String s : operations) {
            int num;
            if (Character.isDigit(s.charAt(0)) || s.length() > 1) {
                num = Integer.parseInt(s);
                deque.addLast(num);
                sum += num;
            } else if (s.equals("+")) {
                int previous = deque.pollLast();
                int prePrevious = deque.peekLast();
                num = prePrevious + previous;
                deque.addLast(previous);
                deque.addLast(num);
                sum += num;
            } else if (s.equals("D")) {
                num = deque.peekLast() * 2;
                deque.addLast(num);
                sum += num;
            } else {
                sum -= deque.removeLast();
            }
        }

        return sum;
    }

    // BEATS 47%
    public static int calPoints1(String[] operations) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (String s : operations) {
            if (Character.isDigit(s.charAt(0)) || s.length() > 1) {
                deque.addLast(Integer.parseInt(s));
            } else if (s.equals("+")) {
                int previous = deque.pollLast();
                int prePrevious = deque.peekLast();
                deque.addLast(previous);
                deque.addLast(prePrevious + previous);
            } else if (s.equals("D")) {
                deque.addLast(deque.peekLast() * 2);
            } else {
                deque.removeLast();
            }
        }

        int sum = 0;
        while (!deque.isEmpty()) {
            sum += deque.poll();
        }

        return sum;
    }
}