package Recursion;

public class power_linear {
    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        int res = power(x, n);
        System.out.println("The result is: " + res);
    }

    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }
        int power_prev = power(x, n-1);
        int power_curr = x * power_prev;
        return power_curr;
    }
}
