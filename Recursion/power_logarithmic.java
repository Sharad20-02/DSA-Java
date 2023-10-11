package Recursion;

public class power_logarithmic {
    public static void main(String[] args) {
        int x = 2;
        int n = 9;
        int res = power(x, n);
        System.out.println("The result is: " + res);
    }

    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }
        int power_prev = power(x, n/2);
        int power_curr = power_prev * power_prev;

        if(n%2 == 1){
            power_curr = power_curr * x;
        }
        return power_curr;
    }
}
