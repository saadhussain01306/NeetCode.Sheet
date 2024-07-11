class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> h=new HashSet<>();

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char ch=board[i][j];
                if(ch!='.'){
                    String row=ch+"at row"+i;
                    String col=ch+"at col"+j;
                    String box=ch+"at box"+i/3+"-"+j/3;
                    if(!h.add(row) || !h.add(col) || !h.add(box)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
