public class Main {
    public static void main(String[] args) {
        String syntax = "(5*(4+3))";

        AnalyseSynthetic analyseSynthetic = new AnalyseSynthetic();

        analyseSynthetic.execute(syntax);
    }
}
