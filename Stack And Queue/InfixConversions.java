import java.util.Stack;

public class InfixConversions {
    public static void main(String[] args) {
        String exp1 = "a*(b-c)/d+e";

        Stack<Character> ops = new Stack<>();
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();

        for(int i=0; i<exp1.length(); i++){
            char ch = exp1.charAt(i);

            if(ch == '('){
                ops.push(ch);
            }else if(ch == ')'){
                while(ops.peek()!='('){
                    char op = ops.pop();

                    String pres2 = pre.pop();
                    String pres1 = pre.pop();
                    String preres = op + pres1 + pres2;
                    pre.push(preres);

                    String posts2 = post.pop();
                    String posts1 = post.pop();
                    String postres = posts1 + posts2 + op;
                    post.push(postres);
                }
                ops.pop();
            }else if( (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <='9') ){
                pre.push(Character.toString(ch));
                post.push(Character.toString(ch));
            }else{
                while(!ops.isEmpty() && ops.peek()!='(' && precedence(ops.peek()) >= precedence(ch)){
                    char op = ops.pop();

                    String pres2 = pre.pop();
                    String pres1 = pre.pop();
                    String preres = op + pres1 + pres2;
                    pre.push(preres);

                    String posts2 = post.pop();
                    String posts1 = post.pop();
                    String postres = posts1 + posts2 + op;
                    post.push(postres);

                }
                ops.push(ch);
            }
        }

        while(!ops.isEmpty()){
            char op = ops.pop();

            String pres2 = pre.pop();
            String pres1 = pre.pop();
            String preres = Character.toString(op) + pres1 + pres2;
            pre.push(preres);

            String posts2 = post.pop();
            String posts1 = post.pop();
            String postres = posts1 + posts2 + Character.toString(op);
            post.push(postres);
        }

        System.out.println("PreOrder = " + pre);
        System.out.println("PostOrder = " + post);
    }

    public static int precedence(char operator){
        int val = 0;
        switch(operator){
            case '+':
            val = 1;
            break;

            case '-':
            val = 1;
            break;

            case '*':
            val = 2;
            break;

            case '/':
            val = 2;
            break;
        }
        return val;
    }
}
