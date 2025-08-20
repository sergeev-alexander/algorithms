package sergeev.alexander.leetcode;

// 2. Add Two Numbers
public class a2 {

    /*
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     */

    public static void main(String[] args) {
        ListNode l1 =
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(9)));
        ListNode l2 =
                new ListNode(5,
                        new ListNode(7));
        System.out.println(addTwoNumbers(l1, l2));
    }

    // BEATS 100%
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;

            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }


    public static class ListNode {
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
            return "(" + val + ") -> " + next;
        }
    }
}
