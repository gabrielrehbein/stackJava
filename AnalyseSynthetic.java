public class AnalyseSynthetic {
    private Stack<Character> stack;
    private char[] charList;

    private char[] validOperations = {'*', '+', '-', '/'};

    public AnalyseSynthetic(){
        this.stack = new Stack<>();
    }

    private boolean isValidOperation(char c) {
        for (char op : validOperations) {
            if (op == c) {
                return true;
            }
        }
        return false;
    }

    private boolean check(){
        for (int i = 0; i < this.charList.length; i++) {
            if (this.charList[i] == '('){
                this.stack.add(this.charList[i]);
            }
            else if (this.charList[i] == ')'){
                if (this.stack.isEmpty()){
                    return false;
                }
                this.stack.remove();
            }
            else if (isValidOperation(this.charList[i]) && isValidOperation(this.charList[i + 1])){
                return false;
            }
            else if (Character.isDigit(this.charList[i]) && isValidOperation(this.charList[i + 1])){
                this.stack.add(this.charList[i + 1]);
            }
            else if (Character.isDigit(this.charList[i]) && isValidOperation(this.charList[i -1])){
                this.stack.remove();
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
