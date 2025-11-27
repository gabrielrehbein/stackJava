public class AnalyseSynthetic {
    
    private Stack<Character> stack; 
    private String validOperations = "*+-/";

    public AnalyseSynthetic() {
        this.stack = new Stack<>();
    }

    private boolean isOperator(char c) {
        return validOperations.indexOf(c) != -1;
    }

    public boolean execute(String syntax) {
        syntax = syntax.replaceAll("\\s+", "");
        this.stack = new Stack<>();
        boolean expectOperand = true; 

        for (int i = 0; i < syntax.length(); i++) {
            char value = syntax.charAt(i);

            if (value == '(') {
                if (!expectOperand) {
                    System.out.println("ERRO: '(' inesperado. Esperava-se um operador.");
                    return false; 
                }
                this.stack.add(value);
                expectOperand = true; 
            } 
            
            else if (value == ')') {
                if (expectOperand) {
                    System.out.println("ERRO: ')' inesperado após operador ou abertura.");
                    return false;
                }
                
                if (this.stack.isEmpty()) {
                    System.out.println("ERRO: ')' encontrado sem correspondente de abertura.");
                    return false;
                }

                try {
                    this.stack.remove();
                } catch (Exception e) {
                    System.out.println("ERRO: Falha ao remover da pilha.");
                    return false;
                }
                
                expectOperand = false; 
            }

            else if (isOperator(value)) {
                if (expectOperand) {
                    System.out.println("ERRO: Operador '" + value + "' em posição inválida.");
                    return false;
                }
                expectOperand = true;
            }

            else if (Character.isDigit(value)) {

                if (!expectOperand) {
                     if (i > 0 && !Character.isDigit(syntax.charAt(i-1))) {
                         System.out.println("ERRO: Número '" + value + "' inesperado.");
                         return false;
                     }
                }
                expectOperand = false; 
            } 
            

            else {
                System.out.println("ERRO: Caractere inválido encontrado: " + value);
                return false;
            }
        }

        if (!this.stack.isEmpty()) {
            System.out.println("ERRO: Parênteses abertos não foram fechados.");
            return false;
        }

        if (expectOperand) {
            System.out.println("ERRO: Expressão incompleta (terminou com operador).");
            return false;
        }

        System.out.println("SUCESSO: A sintaxe está correta!");
        return true;
    }
}