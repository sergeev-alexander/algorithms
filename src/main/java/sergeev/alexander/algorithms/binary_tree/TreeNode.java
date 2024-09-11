package sergeev.alexander.algorithms.binary_tree;


import java.util.Comparator;

public class TreeNode <T extends Comparable<T>> {

    T value;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

