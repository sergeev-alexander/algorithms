package sergeev.alexander.algorithms.huffman_algorithm;

class BinaryTree {

    private Node root;

    public BinaryTree() {
        root = new Node();
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public int getFrequency() {
        return root.getFrequency();
    }

    public Node getRoot() {
        return root;
    }
}