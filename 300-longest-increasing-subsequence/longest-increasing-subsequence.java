class Solution {
    private int solve(int i,int[]nums,int[] t){
        if(t[i]!=-1) return t[i];
        int ans =1;
        for(int j=0;j<i;j++){
            if(nums[j]<nums[i]){
                ans = Math.max(ans,solve(j,nums,t)+1);
            }
        }
        return t[i] = ans;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] t = new int[n+1];
        Arrays.fill(t,-1);

        int ans = 1;

        for(int i=0;i<n;i++){
            ans = Math.max(ans,solve(i,nums,t));
        }
        return ans;
    }
}