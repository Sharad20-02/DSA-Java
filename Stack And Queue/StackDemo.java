import java.util.Stack;

public class StackDemo{
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(10);
        st.push(30);
        System.out.println(st);
        st.push(50);
        System.out.println(st);
        st.push(70);

        System.out.println(st.peek() + " " + st.size() + " --> " + st);

        st.pop();
        System.out.println(st.peek() + " " + st.size() + " --> " + st);

        st.pop();
        System.out.println(st.peek() + " " + st.size() + " --> " + st);

    }
}