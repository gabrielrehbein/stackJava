public class Fila<T> {
    protected  Node<T> firstNode = null;
    protected Node<T> lastNode = null;

    private void setLastNode(Node<T> newLastNode){
        this.lastNode = newLastNode;
    }

    private void setFirstNode(Node<T> newFirstNode){
        this.firstNode = newFirstNode;
    }

    public T remove(){
        Node<T> tempNode = this.firstNode;
        this.firstNode = this.firstNode.getNextNode();
        return tempNode.getValue();
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
        System.out.println("Adicionou: " + value);
    }

    public void showAllElements(){
        
        if (this.firstNode == null){
            System.out.print("");
            return;
        }

        Node<T> tempNode = this.firstNode;


        String strElements = "";
        strElements += "[ " + firstNode.getValue() + " ] ";
        while(tempNode.getNextNode() != null){
            strElements += "[ " + tempNode.getNextNode().getValue() + " ] "; 
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
        boolean contain = false;

        while(tempNode != null){
            if (tempNode.getValue() == value){
                contain = true;
                break;
            }
            tempNode = tempNode.getNextNode();
        }

        return contain;
    }

    public boolean isEmpty(){
        return this.firstNode == null;
    }
}
