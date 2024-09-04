import java.util.Stack;

public class DuplicateBrackets {
    public static void main(String[] args) {
        String ques1 = "((a+b)+(c+d))"; //? false
        String ques2 = "(a+b)+((c+d))"; //? true

        System.out.println(ques1 + " --> " + areDuplicateBracketsPresent(ques1));
        System.out.println(ques2 + " --> " + areDuplicateBracketsPresent(ques2));

    }

    public static boolean areDuplicateBracketsPresent(String str){
        Stack<Character> st = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch != ')'){
                st.push(ch);
            }else{
                if(st.peek() == '('){
                    return true;
                }else{
                    while(st.peek() != '('){
                        st.pop();
                    }
                    st.pop();
                }
            }
        }
        return false;
    }
}
