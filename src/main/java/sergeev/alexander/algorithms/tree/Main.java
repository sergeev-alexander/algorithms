package sergeev.alexander.algorithms.tree;

public class Main {

    static TreeNode<Integer> root =
            new TreeNode<>(20,
                    new TreeNode<>(7,
                            new TreeNode<>(4, null,
                                    new TreeNode<>(6)),
                            new TreeNode<>(9)),
                    new TreeNode<>(35,
                            new TreeNode<>(31,
                                    new TreeNode<>(28), null),
                            new TreeNode<>(40,
                                    new TreeNode<>(38),
                                    new TreeNode<>(52))));

    public static void main(String[] args) {
        System.out.println(TreeNode.recursiveDFSSum(root));
    }
}
