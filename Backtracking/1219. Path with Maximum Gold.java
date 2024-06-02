/*
In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position, you can walk one step to the left, right, up, or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.
 

Example 1:

Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
Output: 24
Explanation:
[[0,6,0],
 [5,8,7],
 [0,9,0]]
Path to get the maximum gold, 9 -> 8 -> 7.
Example 2:

Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
Output: 28
Explanation:
[[1,0,7],
 [2,0,6],
 [3,4,5],
 [0,3,0],
 [9,0,20]]
Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 15
0 <= grid[i][j] <= 100
There are at most 25 cells containing gold.
*/

class Solution {
    int row=0;
    int col=0;
    int max_gold=0;
    public int getMaximumGold(int[][] grid) {
        row=grid.length;
        col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]>0){
                    max_gold=Math.max(max_gold,dfs(grid,i,j));
                }
            }
        }
        return max_gold;
    }

    private int dfs(int[][] grid,int r,int c){
        if(r<0 || r>=row || c<0 || c>=col || grid[r][c]==0){
            return 0;
        }
        int value=grid[r][c];
        grid[r][c]=0;//mark visited

        
        int up=dfs(grid,r-1,c);
        int down=dfs(grid,r+1,c);
        int left=dfs(grid,r,c-1);
        int right=dfs(grid,r,c+1);

        grid[r][c]=value;//restore the value

        return value+Math.max((Math.max(left,right)),(Math.max(up,down)));

    }
}
