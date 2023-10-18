package Recursion;

public class knights_tour {
    public static void main(String[] args) {
        int n = 5;
        int r = 3;
        int c = 3;

        int[][] chess = new int[n][n];
        knightsTour(chess, r, c, 1);
    }

    public static void displayBoard(int[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void knightsTour(int[][] chess, int r, int c, int move){
        if(r<0 || c<0 || r>=chess.length || c>=chess.length || chess[r][c]>0){
            return;
        }else if(move == chess.length * chess.length){
            chess[r][c] = move;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }

        chess[r][c] = move;
        knightsTour(chess, r-2, c+1, move+1);
        knightsTour(chess, r-1, c+2, move+1);
        knightsTour(chess, r+1, c+2, move+1);
        knightsTour(chess, r+2, c+1, move+1);
        knightsTour(chess, r+2, c-1, move+1);
        knightsTour(chess, r+1, c-2, move+1);
        knightsTour(chess, r-1, c-2, move+1);
        knightsTour(chess, r-2, c-1, move+1);
        chess[r][c] = 0;
    }
}
