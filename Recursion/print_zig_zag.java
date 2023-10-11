package Recursion;

public class print_zig_zag {
    public static void main(String[] args) {
        int n = 2;
        printZigZag(n);
    }

    public static void printZigZag(int n){
        if(n == 0){
            return;
        }
        System.out.println("pre: " + n);
        printZigZag(n-1);
        System.out.println("in: " + n);
        printZigZag(n-1);
        System.out.println("post: " + n);
    }
}
