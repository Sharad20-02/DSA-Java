import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementToRight {
    public static void main(String[] args) {
        int[] arr = {2, 5, 9, 3, 1, 12, 6, 8, 7};
        
        int[] res = new int[arr.length];

        res[res.length-1] = -1;

        Stack<Integer> st = new Stack<>();

        st.push(arr[arr.length-1]);

        for(int i=arr.length-2; i>=0; i--){

            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }
            if(st.isEmpty() == true){
                res[i] = -1;
                st.push(arr[i]);
            }else{
                res[i] = st.peek();
                st.push(arr[i]);
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
