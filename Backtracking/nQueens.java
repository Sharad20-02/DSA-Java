package Backtracking;

public class nQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        boolean[] cols = new boolean[n];
        boolean[] ndiag = new boolean[2*n - 1];
        boolean[] rdiag = new boolean[2*n - 1];
        printnQueens(board, 0, cols, ndiag, rdiag, "");
    }
    public static void printnQueens(boolean[][] board, int row, boolean[] cols, boolean[] ndiag, boolean[] rdiag, String asf){
        if(row == board.length){
            System.out.println(asf + " .");
            return;
        }
        for(int col = 0; col<board[0].length; col++){
            if(cols[col] == false && ndiag[row + col] == false && rdiag[row - col + board.length - 1] == false){
                board[row][col] = true;
                cols[col] = true;
                ndiag[row + col] = true;
                rdiag[row - col + board.length - 1] = true;
                printnQueens(board, row+1, cols, ndiag, rdiag, asf + row + "-" + col + ", ");
                board[row][col] = false;
                cols[col] = false;
                ndiag[row + col] = false;
                rdiag[row - col + board.length - 1] = false;
            }
        }
    }
}
