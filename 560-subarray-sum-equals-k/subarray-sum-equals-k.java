class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixsum = 0;
        int count = 0;
        Map<Integer,Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0,1);
        for(int i=0;i<nums.length;i++){
            prefixsum+= nums[i];

            int remove = prefixsum - k;

            if(prefixSumCount.containsKey(remove)){
                count+= prefixSumCount.get(remove);
            }

            prefixSumCount.put(prefixsum,prefixSumCount.getOrDefault(prefixsum,0) + 1);
        }
        return count;
    }
}