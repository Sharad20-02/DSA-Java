package Recursion;

import java.util.ArrayList;

public class get_maze_paths_jumps {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        ArrayList<String> res = getMazePathsWithJump(m, n , 0, 0);
        System.out.println(res);
    }

    public static ArrayList<String> getMazePathsWithJump(int dr, int dc, int cr, int cc){
        if(cr >= dr || cc >= dc ){
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }
        if(cr == dr-1 && cc == dc-1){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> paths = new ArrayList<>();

        // horizontal moves
        for(int ms=1; ms<= dc-cc; ms++){
            ArrayList<String> hpaths = getMazePathsWithJump(dr, dc, cr, cc+ms);
            for(String hpath : hpaths){
                paths.add("h"+ms+hpath);
            }
        }
        // vertical moves
        for(int ms=1; ms<= dr-cr; ms++){
            ArrayList<String> vpaths = getMazePathsWithJump(dr, dc, cr+ms, cc);
            for(String vpath : vpaths){
                paths.add("v"+ms+vpath);
            }
        }
        // diagonal moves
        for(int ms=1; ms<= dc-cc && ms <= dr-cr; ms++){
            ArrayList<String> dpaths = getMazePathsWithJump(dr, dc, cr+ms, cc+ms);
            for(String dpath : dpaths){
                paths.add("d"+ms+dpath);
            }
        }
        return paths;
    }
}