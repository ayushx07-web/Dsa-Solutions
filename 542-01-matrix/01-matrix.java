class Pair{
    int row;
    int col;
    int steps;
    Pair(int row, int col ,int steps){
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int[][] vis = new int[n][m];
        int[][] dis = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    queue.add(new Pair(i,j,0));
                    vis[i][j]=11;
                }
            }
        }
        int [] delRow = {-1,0,1,0};
        int [] delCol = {0,1,0,-1};
        
        while(!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            int s = queue.peek().steps;
            queue.remove();

            dis[r][c] = s;
            for(int i=0;i<4;i++){
                int nRow = r + delRow[i];
                int nCol = c + delCol[i];

                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m &&  vis[nRow][nCol]==0){
                     vis[nRow][nCol]=1;
                     queue.add(new Pair(nRow,nCol,s+1));
                    
                  }
            }

        }
        return dis;
    }
}