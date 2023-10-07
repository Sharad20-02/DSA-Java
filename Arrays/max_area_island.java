// https://leetcode.com/problems/max-area-of-island/

package Arrays;

public class max_area_island {
    int size = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j);
                }
                if(size>result){
                    result = size;
                }
                size = 0;
            }
        }
        return result;
    }

    void dfs(int[][] grid, int x, int y){
        if(grid[x][y] == 1){
            grid[x][y] = 0;
            size += 1;

            if(x>=1){
                dfs(grid, x-1, y);
            }
            if(y<grid[0].length-1){
                dfs(grid, x, y+1);
            }
            if(x<grid.length-1){
                dfs(grid, x+1, y);
            }
            if(y>=1){
                dfs(grid, x, y-1);
            }
        }
    }
}
