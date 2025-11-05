public class DoubleLinkedList<T> extends Lista<T> {
    @Override
    public void add(T value){
        
        LinkedNode<T> node = new LinkedNode<T>(value);

        if (this.firstNode == null){
            this.setFirstNode(node);
            this.setLastNode(node);
        }
        else {
            LinkedNode<T> tempNode = (LinkedNode<T>) this.lastNode;
            tempNode.setNextNode(node);
            node.setPreviousNode(tempNode);
            this.setLastNode(node); 
        }
        
    }
}
