package sergeev.alexander.data_structures.bst;

public class Main {

    public static void main(String[] args) {
        TreeNode<Integer> root =
                new TreeNode<>(10,
                        new TreeNode<>(5,
                                new TreeNode<>(3),
                                new TreeNode<>(7)),
                        new TreeNode<>(15,
                                null,
                                new TreeNode<>(18)));

        System.out.println(new CheckBalance<Integer>().isBalanced(root));
    }
}