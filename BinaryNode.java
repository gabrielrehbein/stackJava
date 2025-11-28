public class BinaryNode<T> extends Node<T> {

    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNode(T value) {
        super(value);
        this.left = null;
        this.right = null;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }
}
