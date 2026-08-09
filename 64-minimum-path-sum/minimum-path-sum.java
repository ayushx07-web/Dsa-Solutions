class Solution {
    private int solve(int i,int j,int[][] t,int[][] grid){
        if(i<0 || j<0) return Integer.MAX_VALUE;
        if(i==0 && j==0) return grid[0][0];
        if(t[i][j]!=-1) return t[i][j];

        
        int up = solve(i-1,j,t,grid);
        int left = solve(i,j-1,t,grid);
         int ans = grid[i][j] + Math.min(up,left);
        return t[i][j] = ans;
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] t = new int[m+1][n+1];
        for(int[] i : t){
            Arrays.fill(i,-1);
        }
        return solve(m-1,n-1,t,grid);
    }
}