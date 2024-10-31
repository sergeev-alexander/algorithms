package sergeev.alexander.algorithms.huffman_algorithm;

public class HuffmanTree {
    private final byte ENCODING_TABLE_SIZE = 127;
    private String text;
    private BinaryTree huffmanTree;
    private int[] frequenciesArray;
    private String[] encodingArray;


    public HuffmanTree(String newString) {
        text = newString;
        frequenciesArray = new int[ENCODING_TABLE_SIZE];
        fillFrequenciesArray();
        huffmanTree = getHuffmanTree();
        encodingArray = new String[ENCODING_TABLE_SIZE];
        fillEncodingArray(huffmanTree.getRoot(), "", "");
    }

    private void fillFrequenciesArray() {
        for (int i = 0; i < text.length(); i++) {
            frequenciesArray[(int) text.charAt(i)]++;
        }
    }

    public int[] getFrequenciesArray() {
        return frequenciesArray;
    }

    private BinaryTree getHuffmanTree() {
        PriorityQueue priorityQueue = new PriorityQueue();
        for (int i = 0; i < ENCODING_TABLE_SIZE; i++) {
            if (frequenciesArray[i] != 0) {
                Node newNode = new Node((char) i, frequenciesArray[i]);
                BinaryTree newTree = new BinaryTree(newNode);
                priorityQueue.insert(newTree);
            }
        }
        while (true) {
            BinaryTree tree1 = priorityQueue.pop();
            try {
                BinaryTree tree2 = priorityQueue.pop();
                Node newNode = new Node();
                newNode.addChild(tree1.getRoot());
                newNode.addChild(tree2.getRoot());
                priorityQueue.insert(new BinaryTree(newNode));
            } catch (IndexOutOfBoundsException e) {
                return tree1;
            }
        }
    }

    public BinaryTree getTree() {
        return huffmanTree;
    }

    void fillEncodingArray(Node node, String codeBefore, String direction) {
        if (node.isLeaf()) {
            encodingArray[node.getLetter()] = codeBefore + direction;
        } else {
            fillEncodingArray(node.getLeftChild(), codeBefore + direction, "0");
            fillEncodingArray(node.getRightChild(), codeBefore + direction, "1");
        }
    }

    public String[] getEncodingArray() {
        return encodingArray;
    }

    public void displayEncodingArray() {
        fillEncodingArray(huffmanTree.getRoot(), "", "");
        System.out.println("Encoding table:");
        for (int i = 0; i < ENCODING_TABLE_SIZE; i++) {
            if (frequenciesArray[i] != 0) {
                System.out.print((char)i + " ");
                System.out.println(encodingArray[i]);
            }
        }
    }

    String getOriginalString() {
        return text;
    }
}
