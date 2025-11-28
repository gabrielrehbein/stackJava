public class BinaryNode<Integer> extends Node<Integer> {

    private BinaryNode<Integer> left;
    private BinaryNode<Integer> right;

    public BinaryNode(Integer value) {
        super(value);
        this.left = null;
        this.right = null;
    }

    public BinaryNode<Integer> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<Integer> left) {
        this.left = left;
    }

    public BinaryNode<Integer> getRight() {
        return right;
    }

    public void setRight(BinaryNode<Integer> right) {
        this.right = right;
    }
}
