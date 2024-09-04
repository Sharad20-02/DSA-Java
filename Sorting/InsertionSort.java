package Sorting;

public class InsertionSort{
    public static void main(String[] args) {
        int[] arr = {2, 9, 5, 1, 3};
        insertionSort(arr);
        printArray(arr);
    }

    public static void insertionSort(int[] arr){
        for(int i=1; i<=arr.length-1; i++){
            for(int j=i-1; j>=0; j--){
                if(isGreater(arr, j, j+1)){
                    swap(arr, j, j+1);
                }else{
                    break;
                }
            }
        }
    }

    public static boolean isGreater(int[] arr, int i, int j){
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        if(arr[i] > arr[j]){
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

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
        System.out.println("\n");
    }
}