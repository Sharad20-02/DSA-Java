package Backtracking;

public class lexicographical_order {
    public static void main(String[] args) {
        int n = 100;
        
        for(int i=1; i<=9; i++){
            dfs(i, n);
        }
    }
    public static void dfs(int i, int n){
        if( i>n ){
            return;
        }
        System.out.println(i);
        for(int j=0; j<10; j++){
            dfs(i*10 + j, n);
        }
    }
}
