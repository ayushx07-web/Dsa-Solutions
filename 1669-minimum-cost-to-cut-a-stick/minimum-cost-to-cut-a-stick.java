class Solution {
   private int solve(int i,int j,int[][] t,int[] cuts){
    if(i+1==j) return 0;
    if(t[i][j]!=-1) return t[i][j];
    int min = Integer.MAX_VALUE;
    for(int k=i+1;k<j;k++){
        int temp = solve(i,k,t,cuts) + solve(k,j,t,cuts) + cuts[j]-cuts[i];
        min = Math.min(temp,min);
    }
    return t[i][j] = min;
   }

    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        
        int[] arr = new int[m+2];
        arr[0] = 0;
        arr[m+1] = n;
        for(int i=0;i<m;i++){
            arr[i+1] = cuts[i];
        }
       
       Arrays.sort(arr);



        int[][] t = new int[m+2][m+2];
        for(int[]i : t){
            Arrays.fill(i,-1);
        }
        return solve(0,m+1,t,arr);
    }
}