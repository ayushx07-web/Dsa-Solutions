class Solution {
    private int solve(int i,int[] arr,int k,int[] t){
        if(i==arr.length) return 0;
        if(t[i]!=-1) return t[i];
        int max = 0;
        int len =0;
        int ans = 0;
    
        for(int j=i;j<Math.min(i+k,arr.length);j++){
           // len++;
            max = Math.max(max,arr[j]);
            len++;
            int temp = len*max + solve(j+1,arr,k,t);
            ans = Math.max(ans,temp);        
        }
        return  t[i]=ans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] t = new int[n+1];
        Arrays.fill(t,-1);
        return solve(0,arr,k,t);
    }
}