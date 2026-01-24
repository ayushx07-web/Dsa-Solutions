class Solution {
    public boolean helper(char[][]board,int row,int col,char c){
        for(int i=0;i<9;i++){
            if(board[row][i]==c) return false;
            if(board[i][col]==c) return false;
            if(board[3*(row/3)+(i/3)][3*(col/3)+(i%3)]==c) return false;

        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
    for(int row=0;row<9;row++){
    for(int col = 0;col<9;col++){
        char c = board[row][col];
        if(c!= '.'){
            board[row][col] = '.';
            if(!helper(board,row,col,c)){
                return false;
            }
            board[row][col] = c;
        }

    }
}
      return true;
        
    }
}