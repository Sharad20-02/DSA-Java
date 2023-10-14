package Recursion;

import java.util.ArrayList;

public class get_maze_paths_jumps {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        ArrayList<String> res = getMazePathsWithJump(m, n , 0, 0);
        System.out.println(res);
    }

    public static ArrayList<String> getMazePathsWithJump(int m, int n, int current_row, int current_col){
        if(current_row >= m || current_col >= n ){
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }
        if(current_row == m-1 && current_col == n-1){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> horizontalPaths1 = getMazePathsWithJump(m, n, current_row, current_col+1);
        ArrayList<String> horizontalPaths2 = getMazePathsWithJump(m, n, current_row, current_col+2);
        ArrayList<String> horizontalPaths3 = getMazePathsWithJump(m, n, current_row, current_col+3);

        ArrayList<String> verticalPaths1 = getMazePathsWithJump(m, n, current_row+1, current_col);
        ArrayList<String> verticalPaths2 = getMazePathsWithJump(m, n, current_row+2, current_col);
        ArrayList<String> verticalPaths3 = getMazePathsWithJump(m, n, current_row+3, current_col);

        ArrayList<String> diagonalPaths1 = getMazePathsWithJump(m, n, current_row+1, current_col+1);
        ArrayList<String> diagonalPaths2 = getMazePathsWithJump(m, n, current_row+2, current_col+2);
        ArrayList<String> diagonalPaths3 = getMazePathsWithJump(m, n, current_row+3, current_col+3);

        ArrayList<String> allPaths = new ArrayList<>();
        for(String path : horizontalPaths1){
            allPaths.add("h1" + path);
        }
        for(String path : horizontalPaths2){
            allPaths.add("h2" + path);
        }
        for(String path : horizontalPaths3){
            allPaths.add("h3" + path);
        }

        for(String path : verticalPaths1){
            allPaths.add("v1" + path);
        }
        for(String path : verticalPaths2){
            allPaths.add("v2" + path);
        }
        for(String path : verticalPaths3){
            allPaths.add("v3" + path);
        }

        for(String path : diagonalPaths1){
            allPaths.add("d1" + path);
        }
        for(String path : diagonalPaths2){
            allPaths.add("d2" + path);
        }
        for(String path : diagonalPaths3){
            allPaths.add("d3" + path);
        }
        return allPaths;
    }
}
