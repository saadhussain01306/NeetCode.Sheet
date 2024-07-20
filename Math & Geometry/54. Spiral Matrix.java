/*
Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]

Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix.length == 0) {
            return res;
        }

        int row_begin = 0;
        int col_begin = 0;
        int row_end = matrix.length - 1;
        int col_end = matrix[0].length - 1;

        while (row_begin <= row_end && col_begin <= col_end) {
            // Traverse Right
            for (int i = col_begin; i <= col_end; i++) {
                res.add(matrix[row_begin][i]);
            }
            row_begin++;

            // Traverse Down
            for (int j = row_begin; j <= row_end; j++) {
                res.add(matrix[j][col_end]);
            }
            col_end--;

            if (row_begin <= row_end) {
                // Traverse Left
                for (int k = col_end; k >= col_begin; k--) {
                    res.add(matrix[row_end][k]);
                }
                row_end--;
            }

            if (col_begin <= col_end) {
                // Traverse Up
                for (int l = row_end; l >= row_begin; l--) {
                    res.add(matrix[l][col_begin]);
                }
                col_begin++;
            }
        }

        return res;
    }
}
