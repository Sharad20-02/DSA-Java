package Recursion;

public class print_maze_paths {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        printMazePaths(rows, cols, 0, 0, "");
    }
    public static void printMazePaths(int dr, int dc, int cr, int cc, String psf){
        if(cr >= dr || cc >= dc){
            return;
        }
        if(cr == dr-1 && cc == dc-1){
            System.out.println(psf);
            return;
        }
        printMazePaths(dr, dc, cr+1, cc, psf+"v");
        printMazePaths(dr, dc, cr, cc+1, psf+"h");
    }
}
