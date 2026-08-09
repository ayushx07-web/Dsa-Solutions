class Solution {
    private int solve(int i,int j,List<List<Integer>> triangle,int[][] t){
        if(i==triangle.size()-1) return triangle.get(i).get(j);
        
        if(t[i][j]!=Integer.MAX_VALUE) return t[i][j];
        int down = solve(i+1,j,triangle,t);
        int diagonal = solve(i+1,j+1,triangle,t);
        int ans = Math.min(down,diagonal) + triangle.get(i).get(j);
        return t[i][j]=ans;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] t = new int[n+1][n+1];
        for(int[] i : t){
         Arrays.fill(i,Integer.MAX_VALUE);
        }
        
        return solve(0,0,triangle,t);
    }
}