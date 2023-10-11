package Recursion;

public class first_index{
    public static void main(String[] args) {
        int[] arr = {20,40,50,3,10,15,50,3,40};
        int data = 3;
        int res = firstIndex(arr, 0, data);
        System.out.println("First index: " + res);
    }

    public static int firstIndex(int[] arr, int idx, int data){
        if(idx == arr.length){
            return -1;
        }
        if(arr[idx] == data){
            return idx;
        }
        int fiisa = firstIndex(arr, idx+1, data);
        return fiisa;
    }
}