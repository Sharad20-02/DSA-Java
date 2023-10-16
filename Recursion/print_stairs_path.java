package Recursion;

public class print_stairs_path {
    public static void main(String[] args) {
        int n = 4;
        printStairsPath(n, "");
    }
    public static void printStairsPath(int n, String ans){
        if(n<0){
            return;
        }
        if(n == 0){
            System.out.println(ans);
            return;
        }
        printStairsPath(n-1, ans+"1");
        printStairsPath(n-2, ans+"2");
        printStairsPath(n-3, ans+"3");
    }
}
