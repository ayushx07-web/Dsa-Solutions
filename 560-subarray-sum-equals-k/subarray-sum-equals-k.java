class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int PrefixSum=0,count=0;
        for(int num : nums){
           PrefixSum+=num;
           if(map.containsKey(PrefixSum-k)){
            count+= map.get(PrefixSum-k);
           }
           map.put(PrefixSum,map.getOrDefault(PrefixSum,0) + 1);
        }
          return count;
    }
}