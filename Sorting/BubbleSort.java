package Sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 9, 8, 2, 1};
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] arr){
        for(int itr=1; itr<=arr.length-1; itr++){
            for(int j=0; j<arr.length-itr; j++){
                if(isSmaller(arr, j+1, j)){
                    swap(arr, j, j+1);
                }
            }
        }
        System.out.println("After sorting: ");
        printArray(arr);
    }

    public static void swap(int[] arr, int i, int j){
        System.out.println("Swapping " + arr[i] + " and " + arr[j] + "\n");
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isSmaller(int[] arr, int i, int j){
        System.out.println("Comparing " + arr[i] + " and " + arr[j] + "\n");
        if(arr[i] < arr[j]){
            return true;
        }else{
            return false;
        }
    }

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
        System.out.println("\n");
    }
}
