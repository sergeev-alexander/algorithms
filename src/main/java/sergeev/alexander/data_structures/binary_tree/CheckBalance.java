package sergeev.alexander.data_structures.binary_tree;

public class CheckBalance<T extends Comparable<T>> {

    // FAST
    public boolean isBalanced(TreeNode<T> root) {
        return checkBalance(root) != -1;
    }

    private int checkBalance(TreeNode<T> root) {
        if (root == null) return 0;

        int leftHeight = checkBalance(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkBalance(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // SLOW
    private boolean isBalancedSLOW(TreeNode<T> root) {
        if (root == null) return true;

        int leftHeight = checkHeight(root.left);
        int rightHeight = checkHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) return false;

        return isBalancedSLOW(root.left) && isBalanced(root.right);
    }

    private int checkHeight(TreeNode<T> root) {
        if (root == null) return -1;

        return 1 + Math.max(checkHeight(root.left), checkHeight(root.right));
    }
}