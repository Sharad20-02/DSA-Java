package Recursion;

public class print_increasing {
    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        int n = 5;
        printIncreasing(n);
    }

    public static void printIncreasing(int n){
        if(n == 0){
            return;
        }
        printIncreasing(n-1);
        System.out.println(n);
    }
}
