public class Stack<T> extends Fila<T> {
    public T getTop(){
        return this.getLastNode().getValue();
    }

    @Override
    public T remove(){
        
        if (this.firstNode == null) {
            throw new IllegalStateException("Stack is empty");
        }

        if (this.firstNode.getNextNode() == null){
            T value = this.firstNode.getValue();
            this.firstNode = null;
            this.lastNode = null;
            System.out.println("Removeu: " + value);
            return value;
        }
        
        T lastValue = this.getLastNode().getValue();
        System.out.println("Removeu: " + lastValue);

        Node<T> tmpNode = this.getFirstNode();

        Node<T> pivo = tmpNode;

        while(tmpNode != null){
            if (tmpNode.getNextNode() == null){
                System.out.println(tmpNode.getValue());
                pivo.setNextNode(null);
                break;
            }
            pivo = tmpNode;
            tmpNode = tmpNode.getNextNode();
        }
        this.lastNode = pivo;
        return lastValue;
    }
}