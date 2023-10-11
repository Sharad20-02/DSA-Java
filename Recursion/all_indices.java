package Recursion;

public class all_indices {
    public static void main(String[] args) {
        int[] arr = {20,10,3,45,67,3,41,23,78,9,78,99,3,5,7,4,5};
        int data = 3;
        int[] res = allIndices(arr, 0, data, 0);
        System.out.println("All Occurences of " + data + ": ");
        for(int i=0; i<res.length; i++){
            System.out.println(res[i]);
        }
    }

    public static int[] allIndices(int[] arr, int idx, int data, int fsf){
        if(idx == arr.length){
            return new int[fsf];
        }

        if(arr[idx] == data){
           int[] res = allIndices(arr, idx+1, data, fsf+1);
           res[fsf] = idx;
           return res;

        }else{
            int[] res = allIndices(arr, idx+1, data, fsf);
            return res;
        }        
    }
}
