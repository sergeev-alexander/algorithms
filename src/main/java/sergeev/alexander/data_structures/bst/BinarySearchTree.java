package sergeev.alexander.data_structures.bst;

public class BinarySearchTree<T extends Comparable<T>> {

    private TreeNode<T> root;

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

    public boolean containsNode(T value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(TreeNode<T> current, T value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        if (value.compareTo(current.value) < 0){
            return containsNodeRecursive(current.left, value);
        } else {
            return containsNodeRecursive(current.right, value);
        }
    }
}
