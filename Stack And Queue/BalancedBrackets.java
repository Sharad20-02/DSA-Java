import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {



        String str1 = "[(a+b)+{(c+d)*(e/f)}]";   //? true
        String str2 = "[(a+b)+{(c+d)*(e/f)]}";   //? false
        String str3 = "[(a+b)+{(c+d)*(e/f)}";    //? false
        String str4 = "([(a+b)+{(c+d)*(e/f)}]";  //? false
        String str5 = "[(a+b)+{(c+d)*(e/f)}]]";  //? false
        String str6 = "[(a+b)))+{(c+d)*(e/f)}]";  //? false

        System.out.println(str1 + " --> " + isBalanced(str1));
        System.out.println(str2 + " --> " + isBalanced(str2));
        System.out.println(str3 + " --> " + isBalanced(str3));
        System.out.println(str4 + " --> " + isBalanced(str4));
        System.out.println(str5 + " --> " + isBalanced(str5));
        System.out.println(str6 + " --> " + isBalanced(str6));
        
    }

    public static boolean isBalanced(String str){
        Stack<Character> st = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch == ')' || ch == '}' || ch == ']'){

                if(st.empty() == true){
                    return false;
                }

                while(st.peek() != '(' && st.peek() != '{' && st.peek() != '['){
                    st.pop();
                }
                if( (ch == ')' && st.peek() == '(') || (ch == '}' && st.peek() == '{') || (ch == ']' && st.peek() == '[') ){
                    st.pop();
                }else{
                    return false;
                }

            }else{
                st.push(ch);
            }
        }

        if(st.empty() == false){
            return false;
        }else{
            return true;
        }
        
    }
}
