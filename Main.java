import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        while (true){

            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite uma expressão: ");
            String syntax = scanner.next();

            AnalyseSynthetic analyseSynthetic = new AnalyseSynthetic();
    
            boolean isValid = analyseSynthetic.execute(syntax);
        }



    }
}
