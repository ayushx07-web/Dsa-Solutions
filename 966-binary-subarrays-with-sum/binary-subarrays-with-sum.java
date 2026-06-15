class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int prefixsum =0 ;
        Map<Integer,Integer> map  = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            prefixsum+= nums[i];
            
            int remove = prefixsum - goal;
            if(map.containsKey(remove)){
                count+= map.get(remove);
            }
            map.put(prefixsum,map.getOrDefault(prefixsum,0)+ 1);
        }
        return count;
    }
}