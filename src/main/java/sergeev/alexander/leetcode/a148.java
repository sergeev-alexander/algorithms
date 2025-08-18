package sergeev.alexander.leetcode;

import java.util.*;

public class a148 {

    public static void main(String[] args) {
        ListNode head =
                new ListNode(4,
                        new ListNode(2,
                                new ListNode(1,
                                        new ListNode(3))));

        System.out.println(sortList(head));
    }

    // BEATS 5%
    public static ListNode sortList(ListNode head) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        while (head != null) {
            priorityQueue.add(head.val);
            head = head.next;
        }

        if (!priorityQueue.isEmpty()) {
            head = new ListNode(priorityQueue.poll());
        } else return null;

        ListNode dummy = head;

        while (!priorityQueue.isEmpty()) {
            head.next = new ListNode(priorityQueue.poll());
            head = head.next;
        }

        return dummy;
    }


    static class ListNode {
        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "(" + val + ")" + next;
        }
    }
}
