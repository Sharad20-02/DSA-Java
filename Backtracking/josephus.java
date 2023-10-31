package Backtracking;

public class josephus {
    public static void main(String[] args) {
        int n = 8;
        int k = 3;

        int res = solveJosephus(n, k);
        System.out.println("Result is : " + res);
    }
    public static int solveJosephus(int n, int k){
        if(n == 1){
            return 0;
        }
        int sofnm1 = solveJosephus(n-1, k);
        int sofn = (sofnm1 + k) % n;
        return sofn;
    }
}
