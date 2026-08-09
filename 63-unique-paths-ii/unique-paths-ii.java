class Solution {
    private int solve(int i, int j,int[][] obstacleGrid,int[][] t){
      
        if(i<0 || j<0) return 0;
        if(obstacleGrid[i][j]==1) return 0; 
        if(i==0 && j==0) return 1;
        
        
        if(t[i][j]!=-1) return t[i][j];
       
        
          int up =  solve(i-1,j,obstacleGrid,t);
          int left = solve(i,j-1,obstacleGrid,t);
          int ans = up + left;
         return t[i][j] = ans;        
        
          
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] t = new int[m+1][n+1];
        for(int[] i : t){
            Arrays.fill(i,-1);
        }
        return solve(m-1,n-1,obstacleGrid,t);
    }
}