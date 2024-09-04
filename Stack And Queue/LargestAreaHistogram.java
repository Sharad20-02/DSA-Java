import java.util.Stack;

public class LargestAreaHistogram {
    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};

        int[] rb = new int[arr.length]; //? next smaller element on the right
        int[] lb = new int[arr.length]; //? next smaller element on the left

        nextSmallerElementOnRight(arr, rb);
        nextSmallerElementOnLeft(arr, lb);

        int maxArea = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            int left = lb[i];
            int right = rb[i];

            int width = right - left - 1;
            int height = arr[i];
            int area = width * height;
            maxArea = Math.max(maxArea, area);
        }

        System.out.println("Max Area is: " + maxArea);

    }

    public static void nextSmallerElementOnRight(int[] arr, int[] rb){
        Stack<Integer> st = new Stack<>();
        rb[rb.length-1] = rb.length-1;
        st.push(rb.length-1);

        for(int i=arr.length-2; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty() == true){
                rb[i] = rb.length - 1;
            }else{
                rb[i] = st.peek();
            }
            st.push(i);
        }
    }

    public static void nextSmallerElementOnLeft(int[] arr, int[] lb){
        Stack<Integer> st = new Stack<>();
        lb[0] = 0;
        st.push(0);

        for(int i=1; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty() == true){
                lb[i] = 0;
            }else{
                lb[i] = st.peek();
            }
            st.push(i);
        }
        
    }
}
