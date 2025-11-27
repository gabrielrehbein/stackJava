public class Lista<T> {

    protected Node<T> firstNode = null;
    protected Node<T> lastNode = null;

    protected void setLastNode(Node<T> newLastNode){
        this.lastNode = newLastNode;
    }

    protected void setFirstNode(Node<T> newFirstNode){
        this.firstNode = newFirstNode;
    }

    public void add(T value){
        Node<T> node = new Node<T>(value);

        if (this.firstNode == null){
            this.setFirstNode(node);
            this.setLastNode(node);
        }
        else {
            Node<T> tempNode = this.lastNode;
            tempNode.setNextNode(node);
            this.lastNode = node;
        }
    }

    public void showAllElements(){
        Node<T> tempNode = this.firstNode;
    
        if (tempNode == null){
            System.out.println("[]");
            return;
        }
    
        String strElements = "";
        while(tempNode != null){ 
            strElements += "[" + tempNode.getValue() + "] "; 
            tempNode = tempNode.getNextNode();
        }
        System.out.println(strElements);
    }

    public Node<T> getFirstNode() {
        return this.firstNode;
    }

    public Node<T> getLastNode() {
        return this.lastNode;
    }

    public boolean contains(T value){
        Node<T> tempNode = this.firstNode;
    
        while(tempNode != null){
            if (tempNode.getValue().equals(value)){ 
                return true;
            }
            tempNode = tempNode.getNextNode();
        }
        
        return false;
    }

}
