class ListaCircular<T> extends Lista<T> {
    @Override
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
            this.lastNode.setNextNode(this.firstNode);
            tempNode.setNextNode(this.lastNode);
        }
    }

    @Override
    public void showAllElements(){
        
        if (this.firstNode == null || this.lastNode == null){
            System.out.print("");
            return;
        }

        
        Node<T> tempNode = this.firstNode;
        String strElements = "";
        do { 
            strElements += "[" + tempNode.getValue() + "] "; 
            tempNode = tempNode.getNextNode();

        } while (tempNode != this.firstNode);
        
        System.out.println(strElements);
    }

    public void append(ListaCircular<T> fila){
        this.lastNode.setNextNode(fila.firstNode);
        this.lastNode=fila.lastNode;
        fila.lastNode.setNextNode(this.firstNode);
        fila.firstNode=this.firstNode;
    }
}
