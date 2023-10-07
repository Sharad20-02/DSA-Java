// https://leetcode.com/problems/fibonacci-number/

package Arrays;

public class fibonacci_number {
     public int fib(int n) {
        if(n<2){
            return n;
        }
        int firstElement = 0;
        int secondElement = 1;
        int result = 0;
        for(int i=2; i<=n; i++){
            result = firstElement + secondElement;
            firstElement = secondElement;
            secondElement = result;
        }
        return result;
    }
}
