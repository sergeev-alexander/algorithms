package sergeev.alexander.algorithms.hoffman_algorithm;

class BinaryTree {

    private Node root;

    public BinaryTree() {
        root = new Node();
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public int getFrequence() {
        return root.getFrequency();
    }

    public Node getRoot() {
        return root;
    }
}