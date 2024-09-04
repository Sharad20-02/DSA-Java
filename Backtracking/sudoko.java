package Backtracking;

public class sudoko {
    public static void main(String[] args) {
        int board[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                         {5, 2, 0, 0, 0, 0, 0, 0, 0},
                         {0, 8, 7, 0, 0, 0, 0, 3, 1},
                         {0, 0, 3, 0, 1, 0, 0, 8, 0},
                         {9, 0, 0, 8, 6, 3, 0, 0, 5},
                         {0, 5, 0, 0, 9, 0, 6, 0, 0},
                         {1, 3, 0, 0, 0, 0, 2, 5, 0},
                         {0, 0, 0, 0, 0, 0, 0, 7, 4},
                         {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        System.out.println("\nInitial Board:");
        printBoard(board);
        System.out.println("\nSudoku Solver's Solution:");
        solveSudoku(board, 0, 0);
    }

    public static void solveSudoku(int board[][], int x, int y){
        if(x>8){
            printBoard(board);
            return;
        }

        int nx = 0;
        int ny = 0;

        if(y == 8){
            ny = 0;
            nx = x + 1;
        }else{
            nx = x;
            ny = y + 1;
        }

        if(board[x][y] != 0){
            solveSudoku(board, nx, ny);
        }else{
            for(int i=1; i<=9; i++){
            if(isValid(board, x, y, i)){
                board[x][y] = i;
                solveSudoku(board, nx, ny);
                board[x][y] = 0;
            }
        }
    }
}

    public static boolean isValid(int board[][], int row, int col, int val){
        for(int c=0; c<9; c++){
            if(board[row][c] == val){
                return false;
            }
        }

        for(int r=0; r<9; r++){
            if(board[r][col] == val){
                return false;
            }
        }

        int rstart = (row / 3) * 3;
        int cstart = (col / 3) * 3;

        for(int i=rstart; i<rstart+3; i++){
            for(int j=cstart; j<cstart+3; j++){
                if(board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }

    public static void printBoard(int board[][]){
        for(int i=0; i<9; i++){
             if(i == 0){
                System.out.println("\n-----------------------");
            }
            System.out.print("| ");
            for(int j=0; j<9; j++){
                System.out.print(board[i][j] + " ");
                if(j==2 || j==5 || j==8){
                    System.out.print("|");
                }
            }
            if(i==2 || i==5 || i==8){
                System.out.println("\n-----------------------");
            }else{
                System.out.print("\n");
            }
        }
    }
}
