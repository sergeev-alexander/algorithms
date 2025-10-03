package sergeev.alexander.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// 938. Range Sum of BST
public class a938 {

    /*
    Given the root node of a binary search tree and two integers low and high,
    return the sum of values of all nodes with a value in the inclusive range [low, high].
     */

    public static void main(String[] args) {
        TreeNode root =
                new TreeNode(10,
                        new TreeNode(5,
                                new TreeNode(3),
                                new TreeNode(7)),
                        new TreeNode(15,
                                null,
                                new TreeNode(18)));
        int low = 7, high = 15;
        System.out.println(rangeSumBST(root, low, high));
    }

    // BEATS 100%
    public static int rangeSumBST(TreeNode root, int low, int high) {
        return ((root != null && root.val <= high && root.val >= low) ? root.val : 0)
                + ((root != null && root.val > low) ? rangeSumBST(root.left, low, high) : 0)
                + ((root != null && root.val < high) ? rangeSumBST(root.right, low, high) : 0);
    }


    // BETAS 100%
    public static int rangeSumBST4(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;

        if (root.val <= high && root.val >= low) {
            sum += root.val;
        }

        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }

        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }

        return sum;
    }

    // BEATS 6%
    public static int rangeSumBST3(TreeNode root, int low, int high) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.val <= high && current.val >= low) {
                sum += current.val;
            }

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return sum;
    }

    // BEATS 6%
    public static int rangeSumBST2(TreeNode root, int low, int high) {
        int sum = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            TreeNode current = deque.poll();

            if (current.val <= high && current.val >= low) {
                sum += current.val;
            }

            if (current.left != null) {
                deque.offer(current.left);
            }

            if (current.right != null) {
                deque.offer(current.right);
            }
        }

        return sum;
    }

    // BEATS 43%
    public static int rangeSumBST1(TreeNode root, int low, int high) {
        int sum = 0;

        if (root.val <= high && root.val >= low) {
            sum += root.val;
        }

        if (root.left != null) {
            sum += rangeSumBST(root.left, low, high);
        }

        if (root.right != null) {
            sum += rangeSumBST(root.right, low, high);
        }

        return sum;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
