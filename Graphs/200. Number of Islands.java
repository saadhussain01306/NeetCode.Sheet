/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
*/


class Solution {
    int row=0;
    int col=0;
    public int numIslands(char[][] grid) {
        row=grid.length;
        col=grid[0].length;
        int count=0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid,int i,int j){
       // Out of bound check;
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != '1') {
            return;
        }
        // Mark the cell as visited
        grid[i][j] = '2';
        // DFS in all four directions
        dfs(grid, i, j - 1); // left
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j + 1); // right
        dfs(grid, i + 1, j); // down
    }
}
