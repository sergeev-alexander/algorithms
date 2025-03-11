package sergeev.alexander.leetcode;

public class a1290 {

    public static void main(String[] args) {
        ListNode head =
                new ListNode(1,
                        new ListNode(0,
                                new ListNode(1)));
        System.out.println(getDecimalValue(head));
    }

    // BEATS 100%
    public static int getDecimalValue(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(stringBuilder.toString(), 2);
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
    }
}