package sergeev.alexander.leetcode;

import sergeev.alexander.Temp;

import java.util.LinkedList;
import java.util.Queue;

// 1302. Deepest Leaves Sum
public class a1302 {

    /*
    Given the root of a binary tree, return the sum of values of its deepest leaves.
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

        System.out.println(deepestLeavesSum(root));
    }

    // BEATS 100%
    public static int deepestLeavesSum(TreeNode root) {
        int[] maxDepth = {-1};
        int[] sum = {0};

        dfs(root, 0, maxDepth, sum);
        return sum[0];
    }

    private static void dfs(TreeNode node, int depth, int[] maxDepth, int[] sum) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            if (depth > maxDepth[0]) {
                maxDepth[0] = depth;
                sum[0] = node.val;
            } else if (depth == maxDepth[0]) {
                sum[0] += node.val;
            }
        }

        dfs(node.left, depth + 1, maxDepth, sum);
        dfs(node.right, depth + 1, maxDepth, sum);
    }

    // BEATS 52%
    public static int deepestLeavesSum1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSum = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            levelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                levelSum += current.val;

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }

        return levelSum;
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