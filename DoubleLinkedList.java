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

    public boolean remove(T value) {
        if (this.firstNode == null) {
            return false;
        }

        LinkedNode<T> current = (LinkedNode<T>) this.firstNode;

        while (current != null) {

            if (current.getValue().equals(value)) { 
                LinkedNode<T> prev = current.getPreviousNode();
                LinkedNode<T> next = (LinkedNode<T>) current.getNextNode();

                if (prev == null) {
                    this.setFirstNode(next);
                    if (next != null) {
                        next.setPreviousNode(null);
                    } else { 
                        this.setLastNode(null);
                    }
                } else if (next == null) { 
                    prev.setNextNode(null);
                    this.setLastNode(prev);
                } else {
                    prev.setNextNode(next);
                    next.setPreviousNode(prev);
                }
                
                return true; 
            }
            current = (LinkedNode<T>) current.getNextNode();
        }

        return false;
    }
}
