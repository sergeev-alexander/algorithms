package sergeev.alexander.leetcode;

// 2181. Merge Nodes in Between Zeros
public class a2181 {

    /*
    You are given the head of a linked list, which contains a series of integers separated by 0's.
    The beginning and end of the linked list will have Node.val == 0.
    For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes.
    The modified list should not contain any 0's.
    Return the head of the modified linked list.
     */

    public static void main(String[] args) {
        ListNode head =
                new ListNode(0,
                        new ListNode(3,
                                new ListNode(1,
                                        new ListNode(0,
                                                new ListNode(4,
                                                        new ListNode(5,
                                                                new ListNode(2,
                                                                        new ListNode(0))))))));
        System.out.println(mergeNodes(head));
    }

    // BEATS 99%
    public static ListNode mergeNodes(ListNode head) {
        ListNode current = head;
        ListNode pointer = head.next;

        while (pointer != null) {
            int sum = 0;

            while (pointer.val != 0) {
                sum += pointer.val;
                pointer = pointer.next;
            }

            current.val = sum;
            current.next = pointer.next;
            current = current.next;
            pointer = pointer.next;
        }

        return head;
    }

    // BEATS 81%
    public static ListNode mergeNodes1(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        head = head.next;

        while (head != null) {
            int sum = 0;

            while (head.val != 0) {
                sum += head.val;
                head = head.next;
            }

            current.next = new ListNode(sum);
            current = current.next;
            head = head.next;
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

        public String toString() {
            return "(" + val + ")" + next;
        }
    }
}