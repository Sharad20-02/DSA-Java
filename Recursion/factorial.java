package Recursion;

public class factorial {
    public static void main(String[] args) {
        int n = 5;
        int res = fact(n);
        System.out.println("Factorial of " + n + " is: " + res);
    }

    public static int fact(int n){
        if(n == 1){
            return 1;
        }
        int fact_prev = fact(n-1);
        int fact_curr = n * fact_prev;
        return fact_curr;
    }
}
