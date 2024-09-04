package Sorting;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = {2, 5, 12, 18, 20};
        int[] b = {7, 9, 11, 15, 25, 28, 30, 35};
        mergeSortedArrays(a, b);
    }

    public static void mergeSortedArrays(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0; 
        int j = 0; 
        int k = 0;

        while(i<a.length && j<b.length){
            if(a[i] < b[j]){
                res[k] = a[i];
                i++;
                k++;
            }else{
                res[k] = b[j];
                j++;
                k++;
            }
        }

        while(i<a.length){
            res[k] = a[i];
            i++; 
            k++;
        }

        while(j<b.length){
            res[k] = b[j];
            j++;
            k++;
        }
        printArray(res);
    }

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
        System.out.println("\n");
    }
}
