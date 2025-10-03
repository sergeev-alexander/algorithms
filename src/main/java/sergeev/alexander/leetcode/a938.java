package sergeev.alexander.leetcode;

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

    // BEATS 43%
    public static int rangeSumBST(TreeNode root, int low, int high) {
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
