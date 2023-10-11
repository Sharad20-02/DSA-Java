package Recursion;

public class print_decreasing{
    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        int n = 5;
        printDecreasing(n);
    }

    public static void printDecreasing(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        printDecreasing(n-1);
    }
}
