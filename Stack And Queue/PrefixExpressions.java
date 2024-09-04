import java.util.Stack;

public class PrefixExpressions {
    public static void main(String[] args) {
        String str = "-+2/*6483"; //? prefix expression

        Stack<Integer> prefix = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> postfix = new Stack<>();

        for(int i=str.length()-1; i>=0; i--){
            char ch = str.charAt(i);

            if(ch>= '0' && ch <='9'){
                infix.push(ch + "");
                postfix.push(ch + "");
                prefix.push(ch - '0');
            }else{
                int val1 = prefix.pop();
                int val2 = prefix.pop();
                int res = performOperation(val1, val2, ch);
                prefix.push(res);

                String inval1 = infix.pop();
                String inval2 = infix.pop();
                String inres = "(" + inval1 + ch + inval2 + ")";
                infix.push(inres);

                String postval1 = postfix.pop();
                String postval2 = postfix.pop();
                String postres = postval1 + postval2 + ch;
                postfix.push(postres);
            }
        }

        System.out.println("Prefix evaluation = " + prefix);
        System.out.println("Postfix = " + postfix);
        System.out.println("Infix = " + infix);

    }

    public static int performOperation(int val1, int val2, char operation){
        int result = 0;
        switch(operation){
            case '+':
            result = val1+val2;
            break;

            case '-':
            result = val1-val2;
            break;

            case '*':
            result = val1*val2;
            break;

            case '/':
            result = val1/val2;
            break;
        }
        return result;
    }

}
