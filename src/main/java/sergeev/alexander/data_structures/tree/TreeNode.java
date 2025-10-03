package sergeev.alexander.data_structures.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode<T> {

    private final T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public static <U extends Number> Number recursiveDFSSum(TreeNode<? extends U> root) {
        double sum = 0;
        sum += root.getValue().doubleValue();
        if (root.left != null) {
            sum += recursiveDFSSum(root.getLeft()).doubleValue();
        }
        if (root.right != null) {
            sum += recursiveDFSSum(root.getRight()).doubleValue();
        }
        return sum;
    }

    public static <U extends Number> Number itarativeDFSSumm(TreeNode<? extends U> root) {
        double sum = 0;
        Deque<TreeNode<? extends U>> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<? extends U> node = stack.pop();
            sum += node.getValue().doubleValue();
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
        }
        return sum;
    }

    public static <U extends Number> Number itarativeBFSSumm(TreeNode<? extends U> root) {
        double sum = 0;
        Queue<TreeNode<? extends U>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<? extends U> node = queue.poll();
            sum += node.getValue().doubleValue();
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return sum;
    }
}