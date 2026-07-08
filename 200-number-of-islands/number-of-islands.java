class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {

    public void bfs(int r,int c,char[][]grid,int[][]vis,int n,int m){
        vis[r][c]=1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(r,c));

        while(!queue.isEmpty()){
             int row = queue.peek().first;
            int col = queue.peek().second;
            queue.remove();

            for(int nRows=-1;nRows<=1;nRows++){
                for(int nCols=-1;nCols<=1;nCols++){
                    int nRow = row + nRows;
                    int nCol = col + nCols;

                    if((nRows==0 || nCols==0) && nRow>=0 && nRow<n && nCol>=0 && nCol<m && 
                         grid[nRow][nCol]=='1' && vis[nRow][nCol]==0){
                            vis[nRow][nCol]=1;
                            queue.add(new Pair(nRow,nCol));
                         }
                }
            }
        }

    }


     public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[][] vis = new int[n][m];
        for(int row = 0;row<n;row++){
            for(int col = 0;col<m;col++){
                if(grid[row][col]=='1' && vis[row][col]==0){
                    bfs(row,col,grid,vis,n,m);
                    count++;
                }
            }
        }
        return count;
    }
}