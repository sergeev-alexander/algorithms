package sergeev.alexander.leetcode;

// 237. Delete Node in a Linked List
public class a237 {

    /*
    There is a singly-linked list head and we want to delete a node node in it.
    You are given the node to be deleted node. You will not be given access to the first node of head.
    All the values of the linked list are unique,
    and it is guaranteed that the given node node is not the last node in the linked list.
    Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:
    The value of the given node should not exist in the linked list.
    The number of nodes in the linked list should decrease by one.
    All the values before node should be in the same order.
    All the values after node should be in the same order.
     */

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        System.out.println(one);
        deleteNode(three);
        System.out.println(one);
    }

    // BEATS 100%
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public String toString() {
            return "(" + val + ") -> " + next;
        }
    }
}