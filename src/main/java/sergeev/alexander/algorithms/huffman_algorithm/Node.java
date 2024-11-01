package sergeev.alexander.algorithms.huffman_algorithm;

public class Node implements Comparable<Node> {

    private Character content;
    private int weight;
    private Node left;
    private Node right;

    public Node(Character content, int weight) {
        this.content = content;
        this.weight = weight;
    }

    public Node(Character content, int weight, Node left, Node right) {
        this.content = content;
        this.weight = weight;
        this.left = left;
        this.right = right;
    }

    public String getCodeForCharacter(Character ch, String parentPath) {
        if (content == ch) {
            return  parentPath;
        } else {
            if (left != null) {
                String path = left.getCodeForCharacter(ch, parentPath + 0);
                if (path != null) {
                    return path;
                }
            }
            if (right != null) {
                String path = right.getCodeForCharacter(ch, parentPath + 1);
                if (path != null) {
                    return path;
                }
            }
        }
        return null;
    }

    public Character getContent() {
        return content;
    }

    public void setContent(Character content) {
        this.content = content;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int compareTo(Node o) {
        return o.weight - weight;
    }
}