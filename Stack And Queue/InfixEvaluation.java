import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) {
        String exp1 = "2+(5-3*6/2)";
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(int i=0; i<exp1.length(); i++){
            char ch = exp1.charAt(i);

            if(Character.isDigit(ch) == true){
                operands.push(Integer.parseInt(Character.toString(ch)));
            }else if(ch == '('){
                operators.push(ch);
            }else if(ch == ')'){
                while(operators.peek() != '('){
                    char operator = operators.pop();
                    int op2 = operands.pop();
                    int op1 = operands.pop();
                    int res = performOperation(op1, op2, operator);
                    operands.push(res);
                }
                operators.pop();
            }else{
            
                while(!operators.isEmpty() && operators.peek() !='(' && precedence(operators.peek()) >= precedence(ch)){
                    char operator = operators.pop();
                    int op2 = operands.pop();
                    int op1 = operands.pop();
                    int res = performOperation(op1, op2, operator);
                    operands.push(res);
                }
                operators.push(ch);  
            }
        }

        while(!operators.isEmpty()){
            char operator = operators.pop();
            int op2 = operands.pop();
            int op1 = operands.pop();
            int res = performOperation(op1, op2, operator);
            operands.push(res);
        }

        System.out.println("Result = " + operands.peek());
        System.out.println("Operands = " + operands);
        System.out.println("operators = " + operators);
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

    public static int performOperation(int op1, int op2, char operator){
        int res = 0;
        switch(operator){
            case '+':
                res = op1 + op2;
                break;

            case '-':
                res = op1 - op2;
                break;

            case '*':
                res = op1 * op2;
                break;

            case '/':
                res = op1 / op2;
                break;
        }

        return res;
    }
}
