import java.util.Stack;

public class PostfixEvaluation {
    public static void main(String[] args) {
        String str = "264*8/+3-"; //? postfix expression

        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<Integer> postfix = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch >= '0' && ch <= '9'){
                infix.push(ch + "");
                prefix.push(ch + "");
                postfix.push(ch - '0');
            }else{
                int v2 = postfix.pop();
                int v1 = postfix.pop();
                int res = performOperation(v1, v2, ch);
                postfix.push(res);

                String pres2 = prefix.pop();
                String pres1 = prefix.pop();
                String preres = ch + pres1 + pres2;
                prefix.push(preres);

                String ins2 = infix.pop();
                String ins1 = infix.pop();
                String inres = "(" + ins1 + ch + ins2 + ")";
                infix.push(inres);               
            }
        }

        System.out.println("Postfix evaluation = " + postfix);
        System.out.println("Prefix = " + prefix);
        System.out.println("Infix = " + infix);
    }

    public static int performOperation(int v1, int v2, char operation){
        int result = 0;
        switch(operation){
            case '+':
            result = v1 + v2;
            break;

            case '-':
            result = v1 - v2;
            break;

            case '*':
            result = v1 * v2;
            break;

            case '/':
            result = v1 / v2;
            break;

        }

        return result;
    }

}
