import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        while(true){
            Scanner scanner1 = new Scanner(System.in);
            System.out.print("(1) Lista Circular\n(2) Analisador Sintético\n(3) Arvore Binaria\n(4) Lista Duplamente Encadeada\nEscolha: ");
            int opt = scanner1.nextInt();
    
            if (opt == 1){
                ListaCircular listaCircular1 = new ListaCircular<>();
    
                
                
                ListaCircular listaCircular2 = new ListaCircular<>();
    
                
    
                listaCircular1.add(1);
                listaCircular1.add(1);
                listaCircular1.add(1);
                listaCircular1.add(1);
                listaCircular1.add(1);
    
                listaCircular2.add(2);
                listaCircular2.add(2);
                listaCircular2.add(2);
                listaCircular2.add(2);
                listaCircular2.add(2);
    
                System.out.println("Lista 1:");
                listaCircular1.showAllElements();
    
                System.out.println("Lista 2:");
                listaCircular2.showAllElements();
    
                listaCircular1.append(listaCircular2);
    
                System.out.println("Listas Juntas");
                
                listaCircular1.showAllElements();
            }
    
            if (opt == 2){
                while (true){
    
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Digite uma expressão: ");
                    String syntax = scanner.next();
        
                    AnalyseSynthetic analyseSynthetic = new AnalyseSynthetic();
            
                    boolean isValid = analyseSynthetic.execute(syntax);
                }
            }
    
            if (opt == 3){
                ArvoreBinaria arv = new ArvoreBinaria();
    
            arv.inserir(50);
            arv.inserir(30);
            arv.inserir(70);
            arv.inserir(20);
            arv.inserir(40);
            arv.inserir(60);
            arv.inserir(80);
    
            System.out.println("Arvore");
            arv.emOrdem();
    
            System.out.println("Buscar 40: " + arv.buscar(40));
            }
            if (opt == 4){
                Scanner scanner = new Scanner(System.in);
                DoubleLinkedList<String> lista = new DoubleLinkedList<>();
                int opcao;

        do {
            System.out.println("\n--- MENU (Lista Dupla) ---");
            System.out.println("1. Adicionar Elemento");
            System.out.println("2. Exibir Elementos");
            System.out.println("3. Remover Elemento");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Entrada inválida.");
                scanner.nextLine();
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Valor a adicionar: ");
                    String valorAdd = scanner.nextLine();
                    lista.add(valorAdd);
                    System.out.println("Adicionado.");
                    break;

                case 2:
                    System.out.print("Lista Normal: ");
                    lista.showAllElements();
                    break;
                

                case 3:
                    System.out.print("Valor a remover: ");
                    String valorRem = scanner.nextLine();
                    if (lista.remove(valorRem)) {
                        System.out.println("Removido com sucesso.");
                    } else {
                        System.out.println("Valor não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção desconhecida.");
                    break;
            }
        } while (opcao != 0);
            }
    
        }
        }

}
