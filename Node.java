public class Node<T> {
    protected T value;
    protected Node<T> nextNode;

    public Node(T value){
        this.value = value;
        this.nextNode = null;
    }

    public T getValue(){
        return this.value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public Node<T> getNextNode(){
        return this.nextNode;
    }

    public void setNextNode(Node<T> nextNode){
        this.nextNode = nextNode;
    }
}
