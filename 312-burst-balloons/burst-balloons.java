class Solution {
    private int solve(int i,int j,int[] arr,int[][] t){
        if(i+1==j) return 0;
        if(t[i][j]!=-1) return t[i][j];
        int max = 0;
        for(int k=i+1;k<j;k++){
            int temp = solve(i,k,arr,t) + solve(k,j,arr,t) + arr[i] * arr[k] * arr[j];
            max = Math.max(max,temp);
        }
        return t[i][j] = max;

    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i=0;i<n;i++){
            arr[i+1] = nums[i];
        }

        int[][] t = new int[n+2][n+2];
        for(int[] i : t){
            Arrays.fill(i,-1);
        }
        return solve(0,n+1,arr,t);
        
    }
}