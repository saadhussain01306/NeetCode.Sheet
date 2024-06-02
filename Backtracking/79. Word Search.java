/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solution faster with a larger board?
*/

class Solution {
    int row = 0;
    int col = 0;

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        boolean result = false;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = dfs(board, word, 0, i, j);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int pos, int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= col || board[r][c] != word.charAt(pos)) {
            return false;
        }

        if (pos == word.length() - 1) {
            return true;
        }

        char value = board[r][c];
        board[r][c] = ' '; // mark as visited

        boolean flag = dfs(board, word, pos + 1, r - 1, c)    /* up */
                    || dfs(board, word, pos + 1, r + 1, c)    /* down */
                    || dfs(board, word, pos + 1, r, c - 1)    /* left */
                    || dfs(board, word, pos + 1, r, c + 1);   /* right */
        // check this in any of the above directions

        board[r][c] = value; // restore the value

        return flag;
    }
}
