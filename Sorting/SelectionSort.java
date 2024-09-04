package Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 9, 8, 1, 2};
        selectionSort(arr);
    }

    public static void selectionSort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(isSmaller(arr, j, min)){
                    min = j;
                }
            }
            swap(arr, i, min);
        }
        printArray(arr);
    }

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
        System.out.println("\n");
    }

    public static boolean isSmaller(int[] arr, int i, int j){
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        if(arr[i] < arr[j]){
            return true;
        }else{
            return false;
        }
    }

    public static void swap(int[] arr, int i, int j){
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }
}
