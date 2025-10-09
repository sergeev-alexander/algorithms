package sergeev.alexander.leetcode;

import sergeev.alexander.Temp;

// 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
public class a1379 {

    /*
    Given two binary trees original and cloned and given a reference to a node target in the original tree.
    The cloned tree is a copy of the original tree.
    Return a reference to the same node in the cloned tree.
    Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.
     */

    // BEATS 98%
    public static TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original != null) {
            TreeNode leftResult = getTargetCopy(original.left, cloned.left, target);
            if (leftResult != null) return leftResult;

            if (original == target) return cloned;

            TreeNode rightResult = getTargetCopy(original.right, cloned.right, target);
            if (rightResult != null) return rightResult;
        }

        return null;
    }

    public static class TreeNode {

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}