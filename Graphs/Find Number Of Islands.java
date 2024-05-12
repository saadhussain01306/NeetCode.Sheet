/*
You are given a 2-dimensional array/list having N rows and M columns, which is filled with ones(1) and zeroes(0). 1 signifies land, and 0 signifies water.

A cell is said to be connected to another cell, if one cell lies immediately next to the other cell, in any of the eight directions (two vertical, two horizontal, and four diagonals).

A group of connected cells having value 1 is called an island. Your task is to find the number of such islands present in the matrix.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 10^3 
1 <= M <= 10^3
0 <= ARR[i][j] <= 1

Time limit: 1sec
Sample Input 1 :
4 5
0 1 1 0 0
1 0 0 1 0
0 0 1 0 0
1 0 0 0 1
Sample Output 1 :
3
Explanation For Sample Input 1 :
The first island of connected 1s is signified by: {0, 1}, {0, 2}, {1, 0}, {1, 3}, {2, 2}.

The second island being: {3, 0}.

The third island being: {3, 4}.
Sample Input 2 :
4 4
1 0 0 1
0 1 1 0
0 1 1 0
1 0 0 1
Sample Output 2 :
1

*/

public class Solution 
{

    static int row=0;
    static int col=0;
    public static int getTotalIslands(int[][] mat) 
	{
        //Your code goes here
        row=mat.length;
        col=mat[0].length;
        int count=0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==1){
                    dfs(mat,i,j);
                    count++;
                }
            }
        }
        return count;
        
    }
    private static void dfs(int[][] mat,int i,int j){
       if(i<0 || i>=row || j<0 || j>=col || mat[i][j]!=1){
           return;
       }
       mat[i][j]=-1;//mark as visited
       dfs(mat,i-1,j);//up
       dfs(mat,i,j-1);//left
       dfs(mat,i,j+1);//right
       dfs(mat,i+1,j);//down
       dfs(mat,i-1,j-1);//top-left
       dfs(mat,i-1,j+1);//top-right
       dfs(mat,i+1,j-1);//bottom-left
       dfs(mat,i+1,j+1);//bottom-right
    }
}
