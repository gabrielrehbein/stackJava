public class AnalyseSynthetic {
    private Stack<Character> stack;
    private char[] charList;

    private char[] validOperations = {'*', '+', '-', '/'};

    public AnalyseSynthetic(){
        this.stack = new Stack<>();
    }

    private boolean check(){
        for (char c : this.charList) {
            if (c == '('){
                this.stack.add(c);
            }
            else if (c == ')'){
                if (this.stack.isEmpty()){
                    return false;
                }
                this.stack.remove();
            }
            else if (Character.isDigit(c)){
                
            }
        }
        return this.stack.isEmpty();
        
    }
    public boolean execute(String syntax){
        syntax = syntax.replaceAll("\\s", "");
        this.charList = syntax.toCharArray();
        boolean isValid = this.check();

        if (isValid){
            System.out.println("SUCESSO: A sintaxe está correta!");
            return isValid;
        }
        throw new Error("ERRO: A sintaxe está incorreta!");
    }
}
