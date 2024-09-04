import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] arr = {4, 7, 9, 5, 6, 1, 2, 3, 18, 14, 10, 11, 12, 13, 6};
        
        int[] res = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        st.push(0);
        res[0] = 1;

        for(int i=1; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            if(st.isEmpty() == true){
                res[i] = i+1;
            }else{
                res[i] = i - st.peek();
            }
            st.push(i);
        }

        System.out.println(Arrays.toString(res));
    }
}
