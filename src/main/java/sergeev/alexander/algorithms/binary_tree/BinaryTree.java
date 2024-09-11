package sergeev.alexander.algorithms.binary_tree;

public class BinaryTree<T extends Comparable<T>> {
    TreeNode<T> root;

    public void add(T value) {
        root = addRecursive(root, value);
    }

    private TreeNode<T> addRecursive(TreeNode<T> current, T value) {
        if (current == null) {
            return new TreeNode<>(value);
        }

        if (value.compareTo(current.value) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

}
