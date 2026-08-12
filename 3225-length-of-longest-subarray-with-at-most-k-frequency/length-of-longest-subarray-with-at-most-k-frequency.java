class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left =0;
        int len = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) { 

             map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
             while(map.get(nums[i])>k){

                map.put(nums[left],map.getOrDefault(nums[left],0)- 1);
                if(map.get(nums[left])==0){
                map.remove(nums[left]);
               }
               left++;
              
            }
               len = Math.max(len,i-left+1);
       }
  
        return len;
    }
}