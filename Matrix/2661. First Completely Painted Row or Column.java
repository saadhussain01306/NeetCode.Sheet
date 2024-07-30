/*
You are given a 0-indexed integer array arr, and an m x n integer matrix mat. arr and mat both contain all the integers in the range [1, m * n].

Go through each index i in arr starting from index 0 and paint the cell in mat containing the integer arr[i].

Return the smallest index i at which either a row or a column will be completely painted in mat.

 

Example 1:

image explanation for example 1
Input: arr = [1,3,4,2], mat = [[1,4],[2,3]]
Output: 2
Explanation: The moves are shown in order, and both the first row and second column of the matrix become fully painted at arr[2].
Example 2:

image explanation for example 2
Input: arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
Output: 3
Explanation: The second column becomes fully painted at arr[3].
 

Constraints:

m == mat.length
n = mat[i].length
arr.length == m * n
1 <= m, n <= 105
1 <= m * n <= 105
1 <= arr[i], mat[r][c] <= m * n
All the integers of arr are unique.
All the integers of mat are unique.
*/

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer,int[]>hm=new HashMap<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                hm.put(mat[i][j],new int[]{i,j});
            }
        }
        int row[]=new int[mat.length];
        int col[]=new int[mat[0].length];
        int i=0;
        for(i=0;i<arr.length;i++){
            int curr[]=hm.get(arr[i]);
            row[curr[0]]++;
            col[curr[1]]++;
            if(row[curr[0]]==mat[0].length ||
                col[curr[1]]==mat.length){
                    break;
            }
        }
        return i;
    }
}
