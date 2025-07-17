package sergeev.alexander.leetcode;

import sergeev.alexander.Temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 872. Leaf-Similar Trees
public class a872 {

    /*
    Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
    Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
     */

    public static void main(String[] args) {

        TreeNode head1 =
                new TreeNode(3,
                        new TreeNode(5,
                                new TreeNode(6),
                                new TreeNode(2,
                                        new TreeNode(7),
                                        new TreeNode(4))),
                        new TreeNode(1,
                                new TreeNode(9),
                                new TreeNode(8)));
        TreeNode head2 =
                new TreeNode(3,
                        new TreeNode(5,
                                new TreeNode(6),
                                new TreeNode(7)),
                        new TreeNode(1,
                                new TreeNode(4),
                                new TreeNode(2,
                                        new TreeNode(9),
                                        new TreeNode(8))));

        System.out.println(leafSimilar(head1, head2));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = traverse(root1, new ArrayList<>());
        List<Integer> list2 = traverse(root2, new ArrayList<>());
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (!Objects.equals(list1.get(i), list2.get(i))) return false;
        }
        return true;
    }

    public static List<Integer> traverse(TreeNode node, List<Integer> resultList) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                resultList.add(node.val);
            }
            TreeNode left = node.left;
            traverse(left, resultList);
            TreeNode right = node.right;
            traverse(right, resultList);
        }
        return resultList;
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