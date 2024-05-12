public class Solution {
    int row = 0;
    int col = 0;
    int maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != 1) {
            return 0;
        }

        int area = 1;
        grid[i][j] = 0; // mark as visited

        area += dfs(grid, i - 1, j);//each time we have a node so upadte the dfs call for the area
        area += dfs(grid, i + 1, j);
        area += dfs(grid, i, j - 1);
        area += dfs(grid, i, j + 1);

        return area;
    }

}
