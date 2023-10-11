package Recursion;

public class display_array_reverse {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        displayArrayReverse(arr, 0);
    }

    public static void displayArrayReverse(int[] arr, int idx){
        if(idx == arr.length){
            return;
        }
        displayArrayReverse(arr, idx+1);
        System.out.println(arr[idx]);
    }
}
