package Recursion;

import java.util.ArrayList;

public class get_maze_paths {
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        
        ArrayList<String> res = getMazePaths(m,n, 0, 0);
        System.out.println(res);
    }

    public static ArrayList<String> getMazePaths(int m, int n, int current_row, int current_col){
        if(current_row >= m || current_col >= n ){
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }
        if(current_row == m-1 && current_col == n-1){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> horizontalPaths = getMazePaths(m, n, current_row, current_col+1);
        ArrayList<String> verticalPaths = getMazePaths(m, n, current_row+1, current_col);

        ArrayList<String> allPaths = new ArrayList<>();
        for(String path : horizontalPaths){
            allPaths.add("h" + path);
        }
        for(String path : verticalPaths){
            allPaths.add("v" + path);
        }
        return allPaths;
    }
}
