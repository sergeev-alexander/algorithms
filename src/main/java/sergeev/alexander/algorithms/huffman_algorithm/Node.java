package sergeev.alexander.algorithms.huffman_algorithm;

public class Node {

    private int frequency;
    private char letter;
    private Node leftChild;
    private Node rightChild;

    public Node() {}

    public Node(char letter, int frequency) {
        this.letter = letter;
        this.frequency = frequency;
    }

    public void addChild(Node addingNode) {
        if (leftChild == null) {
            leftChild = addingNode;
        } else {
            if (leftChild.getFrequency() <= addingNode.getFrequency()) {
                rightChild = addingNode;
            } else {
                rightChild = leftChild;
                leftChild = addingNode;
            }
        }
        frequency += addingNode.getFrequency();
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public int getFrequency() {
        return frequency;
    }

    public char getLetter() {
        return letter;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "frequency=" + frequency +
                ", letter=" + letter +
                '}';
    }
}
