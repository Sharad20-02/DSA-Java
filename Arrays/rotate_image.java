// https://leetcode.com/problems/rotate-image/

package Arrays;

public class rotate_image {
    public void rotate(int[][] matrix) {
        int row = matrix.length;

        for(int i=0; i<row; i++){
            for(int j=0; j<=i; j++){
                swap(matrix, i, j);
            }
        }

        for(int i=0; i<row; i++){
            reverse(matrix[i], row);
        }
    }

    void swap(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    void reverse(int[] matrix, int row){
        int i=0;
        int j=row-1;
        while(i<j){
            int temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
            i++;
            j--;
        }
    }
}
