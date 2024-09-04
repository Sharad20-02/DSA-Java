public class KnightsTour {
    public static void main(String[] args) {
        int n = 5;
        int[][] board = new int[n][n];
        knightsTour(board, 2, 2, 1);
    }

    public static void knightsTour(int[][] board, int row, int col, int count){
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col] != 0){
            return;
        }

        if(count == board.length*board.length){
            board[row][col] = count;
            printArray(board);
            return;
        }

        board[row][col] = count;
        knightsTour(board, row-2, col+1, count+1);
        knightsTour(board, row-1, col+2, count+1);
        knightsTour(board, row+1, col+2, count+1);
        knightsTour(board, row+2, col+1, count+1);
        knightsTour(board, row+2, col-1, count+1);
        knightsTour(board, row+1, col-2, count+1);
        knightsTour(board, row-1, col-2, count+1);
        knightsTour(board, row-2, col-1, count+1);
        board[row][col] = 0;
    }

    public static void printArray(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
