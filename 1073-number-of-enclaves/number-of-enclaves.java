class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int[][] vis = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1){
                        queue.add(new Pair(i,j));
                        vis[i][j]=1;
                    }
                }
            }
        }

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        while(!queue.isEmpty()){
          int r = queue.peek().first;
          int c = queue.peek().second;
          queue.remove();

          for(int i=0;i<4;i++){
          int nRow = r + delRow[i];
          int nCol = c + delCol[i];

          if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && vis[nRow][nCol]==0 && grid[nRow][nCol]==1){
            queue.add(new Pair(nRow,nCol));
            vis[nRow][nCol] = 1;
          }
           }
         }

         int count = 0 ;
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1) count++;
            }
         }
        return count;  
    }
}