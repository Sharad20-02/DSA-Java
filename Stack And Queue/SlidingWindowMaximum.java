import java.util.Arrays;
import java.util.Stack;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {2, 9, 3, 8, 1, 7, 12, 6, 14, 4, 32, 0, 7, 19, 8, 12, 6};
        int k = 4; //? window size

        int[] nge = new int[arr.length];
        NextGreaterElementToRight(arr, nge);

        for(int i=0; i<=arr.length-k; i++){
            int j=i;
            while(nge[j] < i+k){
                j = nge[j];
            }
            System.out.print(arr[j] + " ");
        }


    }

    public static void NextGreaterElementToRight(int[] arr, int[] nge){
        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1);

        nge[arr.length-1] = arr.length; //? Infinity

        for(int i=arr.length-2; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i] = arr.length;
            }else{
                nge[i] = st.peek();
            }
            st.push(i);
        }
    }
}
