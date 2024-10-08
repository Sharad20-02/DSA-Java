package Recursion;

public class floodfill {
    public static void main(String[] args) {
        int row = 6;
        int col = 7;
        int[][] arr = {{0,1,0,0,0,0,0},
                       {0,1,0,1,1,1,0},
                       {0,0,0,0,0,0,0},
                       {1,0,1,1,0,1,1},
                       {1,0,1,1,0,1,1},
                       {1,0,0,0,0,0,0}};
        boolean[][] visited = new boolean[row][col];
        floodFill(arr, 0, 0, "", visited);
    }
    public static void floodFill(int[][] maze, int row, int col, String psf, boolean[][] visited){
        if(row<0 || col<0 || row == maze.length || col == maze[0].length || maze[row][col] == 1 || visited[row][col] == true){
            return;
        }

        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println(psf);
            return;
        }
        visited[row][col] = true;
        floodFill(maze, row-1, col, psf+"t", visited);
        floodFill(maze, row, col-1, psf+"l", visited);
        floodFill(maze, row+1, col, psf+"d", visited);
        floodFill(maze, row, col+1, psf+"r", visited);
        visited[row][col] = false;
    }
}
