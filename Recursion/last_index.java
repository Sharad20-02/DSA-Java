package Recursion;

public class last_index {
    public static void main(String[] args) {
        int[] arr = {20,40,50,3,10,15,50,3,40};
        int data = 3;
        int res = lastIndex(arr, 0, data);
        System.out.println("Last index: " + res);
    }

    public static int lastIndex(int[] arr, int idx, int data){
        if(idx == arr.length){
            return -1;
        }
        int liisa = lastIndex(arr, idx+1, data);
        if(liisa == -1){
            if(arr[idx] == data){
                return idx;
            }else{
                return -1;
            }
        }else{
            return liisa;
        }
    }
}
