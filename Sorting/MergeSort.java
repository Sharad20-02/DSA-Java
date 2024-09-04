package Sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {7, 4, 1, 3, 6, 8 , 2, 5};
        mergeSort(arr, 0, arr.length-1);
    }

    public static void mergeSort(int[] arr, int lo, int hi){

    }

    public static int[] mergeTwoSortedArrays(int[] a, int[] b){
        System.out.println("Merging these two arrays: ");
        System.out.print("Left array ---> ");
        printArray(a);
        System.out.print("Right array ---> ");
        printArray(b);
        int i=0, j=0, k=0;
        int[] ans = new int[a.length + b.length];
        while(i < a.length && j < b.length){
            if(a[i] <= b[j]){
                ans[k] = a[i];
                i++;
                k++;
            }else{
                ans[k] = b[j];
                j++;
                k++;
            }
        }

        while(i < a.length){
            ans[k] = a[i];
            i++;
            k++;
        }

        while(j < b.length){
            ans[k] = b[j];
            j++;
            k++;
        }

        return ans;
    }

    public static void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}
