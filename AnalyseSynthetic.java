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
            char currentChar = this.charList[i];
            System.out.println("Atual: "+ currentChar);
            if (currentChar == '('){
                this.stack.add(this.charList[i]);
            }
            else if (currentChar == ')'){
                if (this.stack.isEmpty()){
                    this.stack.add('E');
                    break;
                }
                this.stack.remove();
            }

            else if (i == 0){
                if (this.isValidOperation(currentChar)) {
                    this.stack.add('E');
                    break;
                }
                if (Character.isDigit(currentChar)) {
                    if (i + 1 < this.charList.length && this.isValidOperation(this.charList[i + 1])) {
                        this.stack.add(this.charList[i + 1]);
                    }
                }
            }

            else if (i == this.charList.length - 1){
                if (this.isValidOperation(currentChar)) {
                    this.stack.add('E');
                    break;
                }
                if (Character.isDigit(currentChar)) {
                    if (isValidOperation(this.charList[i - 1])) {
                        if (this.stack.isEmpty()){
                            break;
                        }
                        this.stack.remove();
                    }
                }
            }


            else if (Character.isDigit(currentChar) && i > 0 && i < this.charList.length - 1){
                char nextChar = this.charList[i + 1];
                char previusChar = this.charList[i - 1];

                if (this.isValidOperation(nextChar)){
                    this.stack.add(nextChar);
                }
                else if (this.isValidOperation(previusChar)){
                    if (this.stack.isEmpty()){
                        break;
                    }
                    this.stack.remove();
                }
            }

            else if (this.isValidOperation(currentChar) && i > 0 && i < this.charList.length - 1){
                char nextChar = this.charList[i + 1];
                char previusChar = this.charList[i - 1];

                if (nextChar == '('){
                    if (this.stack.isEmpty()){
                        break;
                    }
                    this.stack.remove();
                }
                if (previusChar == '('){
                    this.stack.add(currentChar);
                }
            }


            System.out.println("-------------PILHA ATUAL-------------");
            this.stack.showAllElements();
            System.out.println("-------------------------------------");
        }
        return this.stack.isEmpty();
        
    }
    public boolean execute(String syntax){
        syntax = syntax.replaceAll("\\s", "");
        syntax = syntax.replaceAll(" ", "");
        this.charList = syntax.toCharArray();
        boolean isValid = this.check();

        if (isValid){
            System.out.println("SUCESSO: A sintaxe está correta!");
            return isValid;
        }
        throw new Error("ERRO: A sintaxe está incorreta!");
    }
}
