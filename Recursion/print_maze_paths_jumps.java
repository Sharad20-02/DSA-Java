package Recursion;

public class print_maze_paths_jumps {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        printMazePathsJumps(rows, cols, 0, 0, "");
    }
    public static void printMazePathsJumps(int dr, int dc, int cr, int cc, String psf){
        if(cr >= dr || cc>= dc){
            return;
        }
        if(cr == dr-1 && cc == dc-1){
            System.out.println(psf);
            return;
        }
        
        for(int hj=1; hj<dc-cc; hj++){
            printMazePathsJumps(dr, dc, cr, cc+hj, psf + "h" + hj);
        }
        for(int vj=1; vj<dr-cr; vj++){
            printMazePathsJumps(dr, dc, cr+vj, cc, psf + "v" + vj);
        }
        for(int dj=1; dj<dc-cc && dj<dr-cr; dj++){
            printMazePathsJumps(dr, dc, cr+dj, cc+dj, psf + "d" + dj);
        }
    }
}
