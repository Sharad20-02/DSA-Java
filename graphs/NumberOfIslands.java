import java.util.Scanner;

public class NumberOfIslands {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int[][] arr = {{0, 0, 1, 1, 1, 1, 1, 1},
                       {0, 0, 1, 1, 1, 1, 1, 1},
                       {1, 1, 1, 1, 1, 1, 1, 0},
                       {1, 1, 0, 0, 0, 1, 1, 0},
                       {1, 1, 1, 1, 0, 1, 1, 0},
                       {1, 1, 1, 1, 0, 1, 1, 0},
                       {1, 1, 1, 1, 1, 1, 1, 0},
                       {1, 1, 1, 1, 1, 1, 1, 0}}; 
        //? 0 --> Islands
        //? 1 --> Water

        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0;

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == 0 && visited[i][j] == false){
                    drawTreeFromComponent(arr, i, j, visited);
                    count++;
                }
            }
        }

        System.out.println("Number of Islands = " + count);
    }

    public static void drawTreeFromComponent(int[][] arr, int i, int j, boolean[][] visited){

        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j] == 1 || visited[i][j] == true){
            return;
        }

        visited[i][j] = true;

        drawTreeFromComponent(arr, i+1, j, visited);
        drawTreeFromComponent(arr, i-1, j, visited);
        drawTreeFromComponent(arr, i, j+1, visited);
        drawTreeFromComponent(arr, i, j-1, visited);
    }
}
