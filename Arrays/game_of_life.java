// https://leetcode.com/problems/game-of-life/

package Arrays;

public class game_of_life {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] res = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int count = searchFunc(board, i, j, m, n);
                if(board[i][j] == 1 && count <2){
                    res[i][j] = 0;
                }
                else if(board[i][j] == 1 && count>=2 && count<=3){
                    res[i][j] = 1;
                }
                else if(board[i][j] == 1 && count>=3){
                    res[i][j] = 0;
                }
                else if(board[i][j] == 0 && count==3){
                    res[i][j] = 1;
                }
                else{
                    res[i][j] = board[i][j];
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                board[i][j] = res[i][j];
            }
        }
    }

    int search(int[][] board, int row, int col, int m, int n){
        if(row<0 || col<0 || row>=m || col>=n || board[row][col] == 0){
            return 0;
        }
        else{
            return 1;
        }

    }

    int searchFunc(int[][] board, int row, int col, int m, int n){
        int top = search(board, row-1, col, m, n);
        int topRight = search(board, row-1, col+1, m, n);
        int right = search(board, row, col+1, m, n);
        int bottomRight = search(board, row+1, col+1, m, n);
        int bottom = search(board, row+1, col, m, n);
        int bottomLeft = search(board, row+1, col-1, m, n);
        int left = search(board, row, col-1, m, n);
        int topLeft = search(board, row-1, col-1, m, n);

        return top + topRight + right + bottomRight + bottom + bottomLeft + left + topLeft;
    }
}
