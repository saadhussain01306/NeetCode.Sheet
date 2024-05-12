/*
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

 

Example 1:


Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Notice that an 'O' should not be flipped if:
- It is on the border, or
- It is adjacent to an 'O' that should not be flipped.
The bottom 'O' is on the border, so it is not flipped.
The other three 'O' form a surrounded region, so they are flipped.
Example 2:

Input: board = [["X"]]
Output: [["X"]]
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
*/

class Solution {
    int row = 0;
    int col = 0;
    
    public void solve(char[][] board) {
        row = board.length;
        col = board[0].length;
        
        // mark the O's' sorrounded by the boundary 'O's in the first and last column
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][col - 1] == 'O') {
                dfs(board, i, col - 1);
            }
        }

        // now mark the first and the last row
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[row - 1][j] == 'O') {
                dfs(board, row - 1, j);
            }
        }
        
        // Convert remaining 'O' cells to 'X', and revert marked cells back to 'O'
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int i, int j) {
        // Out of bounds check
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'O') {
            return;
        }
        // Mark current 'O' cell as visited
        board[i][j] = '1';
        
        // DFS in all four directions
        dfs(board, i, j - 1); // left
        dfs(board, i - 1, j); // up
        dfs(board, i, j + 1); // right
        dfs(board, i + 1, j); // down
    }
}
