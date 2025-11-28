
public class ArvoreBinaria {

    private BinaryNode<Integer> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(Integer valor) {
        raiz = inserirRec(raiz, valor);
    }

    private BinaryNode<Integer> inserirRec(BinaryNode<Integer> atual, Integer valor) {
        if (atual == null) {
            return new BinaryNode<>(valor);
        }

        if (valor < atual.getValue()) {
            atual.setLeft(inserirRec(atual.getLeft(), valor));
        } else if (valor > atual.getValue()) {
            atual.setRight(inserirRec(atual.getRight(), valor));
        }

        return atual;
    }



    public void emOrdem() {
        emOrdemRec(raiz);
        System.out.println();
    }

    private void emOrdemRec(BinaryNode<Integer> n) {
        if (n != null) {
            emOrdemRec(n.getLeft());
            System.out.print(n.getValue() + " ");
            emOrdemRec(n.getRight());
        }
    }
}
