public class LinkedNode<T> extends Node<T> {
    protected LinkedNode<T> previousNode;

    public LinkedNode(T value){
        super(value);
        this.previousNode = null;
    }

    public LinkedNode<T> getPreviousNode() {
        return this.previousNode;
    }

    public void setPreviousNode(LinkedNode<T> previousNode) {
        this.previousNode = previousNode;
    }

}
