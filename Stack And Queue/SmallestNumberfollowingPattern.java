import java.util.Stack;

public class SmallestNumberfollowingPattern {
    public static void main(String[] args) {
        String exp = "ddidddid";

        Stack<Integer> st = new Stack<>();
        int counter = 1;

        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch == 'd'){
                st.push(counter);
                counter++;
            }else{
                st.push(counter);
                counter++;
                while(!st.isEmpty()){
                    System.out.print(st.pop() + " ");
                } 
            }
        }
        
        st.push(counter);
        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }
    }
}
