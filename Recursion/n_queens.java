package Recursion;

public class n_queens {
    public static void main(String[] args) {
        int n = 4;
        int[][] chess = new int[n][n];
        nQueens(chess, 0, "");
    }

    public static boolean isQueenSafe(int[][] chess, int row, int col){
        for(int i=row-1, j=col; i>=0; i--){
            if(chess[i][j] == 1){
                return false;
            }
        }

        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(chess[i][j] == 1){
                return false;
            }
        }

        for(int i=row-1, j=col+1; i>=0 && j<chess.length; i--, j++){
            if(chess[i][j] == 1){
                return false;
            }
        }
        return true;
    }

    public static void nQueens(int[][] chess, int row, String qsf){
        if(row == chess.length){
            System.out.println(qsf);
            return;
        }
        for(int col=0; col<chess.length; col++){
            if(isQueenSafe(chess, row, col) == true){
                chess[row][col] = 1;
                nQueens(chess, row+1, qsf + row + "-" + col + ", ");
                chess[row][col] = 0;
            }
        }
    }
}
