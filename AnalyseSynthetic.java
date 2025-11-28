public class AnalyseSynthetic {
    
    private Stack<Character> stack; 
    private final String validOperations = "*+-/";

    public AnalyseSynthetic() {
        this.stack = new Stack<>();
    }

    private boolean isOperator(char c) {
        return validOperations.indexOf(c) != -1;
    }

    public boolean execute(String syntax) {

        syntax = syntax.replaceAll("\\s+", "");
        this.stack = new Stack<>();

        for (int i = 0; i < syntax.length(); i++) {

            char value = syntax.charAt(i);

            if (value == '(') {
                stack.add(value);
                continue;
            }

            if (value == ')') {
                try {
                    stack.remove();
                } catch (Exception e) {
                    System.out.println("Sintaxe incorreta");
                    return false;
                }
                continue;
            }

            if (isOperator(value)) {

                if (i + 1 < syntax.length() && syntax.charAt(i + 1) == '(') {
                    try {
                        stack.remove();
                    } catch (Exception e) {
                        System.out.println("Sintaxe incorreta");
                        return false;
                    }
                }

                if (i + 1 < syntax.length() && Character.isDigit(syntax.charAt(i + 1))) {

                    try {
                        stack.remove();
                    } catch (Exception e) {
                        System.out.println("Sintaxe incorreta");
                        return false;
                    }
                }

                continue;
            }

            if (Character.isDigit(value)) {

                if (i + 1 < syntax.length() && isOperator(syntax.charAt(i + 1))) {
                    char op = syntax.charAt(i + 1);
                    stack.add(op);
                }

                continue;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("Sintaxe incorreta");
            return false;
        }

        System.out.println("SUCESSO: A sintaxe está correta!");
        return true;
    }
}
