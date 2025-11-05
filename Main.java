import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int opt = 3;

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


            listaCircular1.append(listaCircular2);

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
            System.out.println("");
        }

    }
}
